package com.wanzhiwen.blog.service;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */
public interface UserService {
    String encrypt(String password);

    Response login(HttpServletRequest request, User user);
}
