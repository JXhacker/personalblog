package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/15
 */

@RestController
public class ImgController {

    @Autowired
    ImgService imgService;

    @RequestMapping(value = "addImg")
    public Response addImg(MultipartFile file, HttpServletRequest request) {
        Response response;
        response = imgService.addImg(file, request);
        return response;
    }

}
