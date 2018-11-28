package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Article;
import com.wanzhiwen.blog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */

@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/insertArticle")
    public Response insertArticle(HttpServletRequest request, @RequestBody Article article) {
        Response response;
        logger.info("insertArticle接口被调用");
        response = articleService.insertArticle(request, article);
        return response;
    }

    @RequestMapping("/getArticleById")
    public Response getArticleById(HttpServletRequest request) {
        Response response;
        logger.info("getArticleById接口被调用");
        response = articleService.getArticleById(request);
        return response;
    }

    @RequestMapping("/getArticlesByType")
    public Response getArticlesByType(HttpServletRequest request){
        Response response;
        logger.info("getArticlesByType接口被调用");
        response=articleService.getArticlesByType(request);
        return response;
    }

    @RequestMapping("/updateArticleById")
    public Response updateArticleById(HttpServletRequest request,@RequestBody Article article){
        Response response;
        logger.info("updateArticleById接口被调用");
        response=articleService.updateArticleById(request,article);
        return response;
    }
}
