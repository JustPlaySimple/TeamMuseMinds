package com.ruoyi.framework.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.user.CaptchaException;
import com.ruoyi.common.exception.user.CaptchaExpireException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysUserService;

/**
 * Registration validation service
 *
 * @author ruoyi
 */
@Component
public class SysRegisterService
{
    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private RedisCache redisCache;

    /**
     * Register a new user
     *
     * @param registerBody registration information (username/email, password, captcha, etc.)
     * @return error message if any, empty string means success
     */
    public String register(RegisterBody registerBody)
    {
        String msg = "";
        String Email = registerBody.getEmail();
        String password = registerBody.getPassword();

        SysUser sysUser = new SysUser();
        sysUser.setEmail(Email);
        sysUser.setUserName(Email.length() > 20 ? Email.substring(0, 20) : Email);
        sysUser.setUserType(registerBody.getUserType());
        // Captcha enabled switch
        boolean captchaEnabled = configService.selectCaptchaEnabled();
//        if (captchaEnabled)
//        {
//            validateCaptcha(username, registerBody.getCode(), registerBody.getUuid());
//        }

        if (StringUtils.isEmpty(Email))
        {
            msg = "Email cannot be empty";
        }
        else if (StringUtils.isEmpty(password))
        {
            msg = "User password cannot be empty";
        }
//        else if (Email.length() < UserConstants.USERNAME_MIN_LENGTH
//                || Email.length() > UserConstants.USERNAME_MAX_LENGTH)
//        {
//            msg = "Username length must be between 2 and 20 characters";
//        }
//        else if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
//                || password.length() > UserConstants.PASSWORD_MAX_LENGTH)
//        {
//            msg = "Password length must be between 5 and 20 characters";
//        }
        else if (!userService.checkUserNameUnique(sysUser))
        {
            msg = "Failed to save user '" + Email + "', registration account already exists";
        }
        else
        {
            sysUser.setNickName("Lucky");
            sysUser.setPwdUpdateDate(DateUtils.getNowDate());
            sysUser.setPassword(SecurityUtils.encryptPassword(password));
            boolean regFlag = userService.registerUser(sysUser);
            if (!regFlag)
            {
                msg = "Registration failed, please contact system administrator";
            }
            else
            {
                AsyncManager.me().execute(AsyncFactory.recordLogininfor(Email, Constants.REGISTER, MessageUtils.message("user.register.success")));
            }
        }
        return msg;
    }

    /**
     * Validate captcha code
     *
     * @param username the username
     * @param code captcha code input
     * @param uuid unique identifier for captcha
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}
