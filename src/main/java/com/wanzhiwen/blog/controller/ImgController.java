package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


    @PostMapping(value = "addImg")
    public Response addImg(MultipartFile file, HttpServletRequest request) {
        Response response;
        response = imgService.addImg(file, request);
        return response;
    }

    @PostMapping(value = "updateCarousel")
    public Response updateCarousel(HttpServletRequest request) {
        Response response;
        response = imgService.updateCarousel(request);
        return response;
    }

    @GetMapping(value = "getCarousels")
    public Response getCarousels() {
        Response response;
        response = imgService.getCarousels();
        return response;
    }

}
