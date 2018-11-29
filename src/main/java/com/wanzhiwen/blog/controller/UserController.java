package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.User;
import com.wanzhiwen.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public Response login(HttpServletRequest request, @RequestBody User user){
        Response response;
        response=userService.login(request,user);
        return response;
    }
}
