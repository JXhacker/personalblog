package com.wanzhiwen.blog.service;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Article;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */
public interface ArticleService {
    Response insertArticle(HttpServletRequest request, Article article);
    Response getArticleById(HttpServletRequest request);
    Response getArticlesByType(HttpServletRequest request);
}
