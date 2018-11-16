package com.wanzhiwen.blog.service;

import com.wanzhiwen.blog.commons.Response;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/15
 */
public interface ImgService {
    Response addImg(MultipartFile file, HttpServletRequest request);

    Response updateCarousel(HttpServletRequest request);

    Response getCarousels();
}
