package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Article;
import com.wanzhiwen.blog.service.ArticleService;
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

    @RequestMapping("/insertArticle")
    public Response insertArticle(HttpServletRequest request, @RequestBody Article article) {
        Response response;
        response = articleService.insertArticle(request, article);
        return response;
    }

    @RequestMapping("/getArticleById")
    public Response getArticleById(HttpServletRequest request) {
        Response response;
        response = articleService.getArticleById(request);
        return response;
    }

    @RequestMapping("/getArticlesByType")
    public Response getArticlesByType(HttpServletRequest request){
        Response response;
        response=articleService.getArticlesByType(request);
        return response;
    }
}
