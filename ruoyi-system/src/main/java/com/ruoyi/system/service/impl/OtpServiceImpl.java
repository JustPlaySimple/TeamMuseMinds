package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.service.IOtpService;
import com.ruoyi.system.service.ISysUserService;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@Service
public class OtpServiceImpl implements IOtpService {

    @Value("${sendgrid.api-key}")
    private String sendGridApiKey;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    private static final String OTP_KEY_PREFIX = "otp:";
    private static final String OTP_ERROR_KEY_PREFIX = "otp:error:";

    private static final int MAX_ATTEMPTS = 5;

    @Override
    public void sendOtpEmail(String toEmail) throws IOException {
        Email from = new Email("Emtforever@outlook.com"); // Replace with verified sender
        String subject = "Your OTP Code";
        Email to = new Email(toEmail);
        String otp = String.format("%06d", new Random().nextInt(999999));
        redisCache.setCacheObject("otp:" + toEmail, otp, 5, TimeUnit.MINUTES);
        Content content = new Content("text/plain", "Your OTP code is: " + otp);
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            System.out.println("SendGrid response: " + response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }


    @Override
    public boolean verifyOtp(String email, String otp) {
        String errorKey = OTP_ERROR_KEY_PREFIX + email;
        String otpKey = OTP_KEY_PREFIX + email;

        System.out.println("email"+ email + otp);

        // Check error attempts
        Integer attempts = redisCache.getCacheObject(errorKey);
        attempts = (attempts == null) ? 0 : attempts;

//        if (attempts >= MAX_ATTEMPTS) {
//            throw new ServiceException("Too many incorrect attempts. Please try again later.");
//        }

        // Get correct OTP
        String cachedOtp = redisCache.getCacheObject(otpKey);
        System.out.println("cachedOtp"+ cachedOtp);
        if (cachedOtp != null && cachedOtp.equals(otp)) {
            // Correct OTP
            redisCache.deleteObject(otpKey);
            redisCache.deleteObject(errorKey); // reset attempts
            return true;
        } else {
            // Wrong OTP
            redisCache.setCacheObject(errorKey, attempts + 1, 10, TimeUnit.MINUTES);
            return false;
        }
    }
}
