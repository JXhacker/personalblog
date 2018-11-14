package com.wanzhiwen.blog.service.Impl;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.dao.UserDao;
import com.wanzhiwen.blog.entity.User;
import com.wanzhiwen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public String encrypt(String password) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String newPassword = base64Encoder.encode(md5.digest(password.getBytes()));
        return newPassword;
    }

    public Response login(HttpServletRequest request, User user) {
        HttpSession session = request.getSession();
        String newPassword;
        User userDB;
        if (user.getPassword() == null || user.getUsername() == null) {
            return new Response(1, "参数不足");
        }
        newPassword = encrypt(user.getPassword());
        user.setPassword(newPassword);
        try {
            userDB = userDao.login(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
        if (userDB==null){
            return new Response(1,"用户名或密码错误");
        }
        session.setAttribute("username", userDB.getUsername());
        session.setAttribute("portrait", userDB.getPortrait());
        return new Response(0,"登陆成功");
    }
}
