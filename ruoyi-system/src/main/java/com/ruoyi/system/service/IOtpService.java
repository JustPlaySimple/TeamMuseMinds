package com.ruoyi.system.service;

import java.io.IOException;

public interface IOtpService {

    /**
     * Sends an OTP email to the specified recipient.
     *
     * @param toEmail recipient's email address
     * @param otp one-time password string
     * @throws IOException if sending fails
     */
    void sendOtpEmail(String toEmail) throws IOException;

    void sendInviteEmail(String toEmail, String password) throws IOException;

    boolean verifyOtp(String email, String otp);

}
