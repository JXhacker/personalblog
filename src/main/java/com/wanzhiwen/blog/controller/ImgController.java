package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.service.ImgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "addImg")
    public Response addImg(MultipartFile file, HttpServletRequest request) {
        Response response;
        logger.info("updateArticleById接口被调用");
        response = imgService.addImg(file, request);
        return response;
    }

    @RequestMapping(value = "updateCarousel")
    public Response updateCarousel(HttpServletRequest request) {
        Response response;
        logger.info("updateCarousel接口被调用");
        response = imgService.updateCarousel(request);
        return response;
    }

    @RequestMapping(value = "getCarousels")
    public Response getCarousels() {
        Response response;
        logger.info("getCarousels接口被调用");
        response = imgService.getCarousels();
        return response;
    }

}
