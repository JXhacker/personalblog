package com.wanzhiwen.blog.service.Impl;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.dao.ArticleDao;
import com.wanzhiwen.blog.entity.Article;
import com.wanzhiwen.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    public Response insertArticle(HttpServletRequest request, Article article) {
        Date date = new Date();
        HttpSession session=request.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("portrait") == null) {
            return new Response(1, "未登录");
        }
        article.setAddTime(date);
        article.setAuthorName((String)session.getAttribute("username"));
        article.setAuthorPortrait((String)session.getAttribute("portrait"));
        try {
            articleDao.insertArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
        return new Response(0, "文章添加成功");
    }
}
