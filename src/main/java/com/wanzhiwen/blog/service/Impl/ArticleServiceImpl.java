package com.wanzhiwen.blog.service.Impl;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.dao.ArticleDao;
import com.wanzhiwen.blog.entity.Article;
import com.wanzhiwen.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    public Response insertArticle(HttpServletRequest request, Article article) {
        Date date = new Date();
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("portrait") == null) {
            return new Response(1, "未登录");
        }
        article.setAddTime(date);
        article.setAuthorName((String) session.getAttribute("username"));
        article.setAuthorPortrait((String) session.getAttribute("portrait"));
        try {
            articleDao.insertArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
        return new Response(0, "文章添加成功");
    }

    public Response getArticleById(HttpServletRequest request) {
        int id;
        Article articleDB;
        Response response = new Response();
        if (request.getParameter("id") == null) {
            return new Response(1, "参数错误");
        }
        id = Integer.parseInt(request.getParameter("id"));
        try {
            articleDB = articleDao.getArticleById(id);
            articleDao.addview(articleDB.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
        response.setStatus(0);
        response.setMsg("查询成功");
        response.setBody(articleDB);
        return response;
    }

    public Response getArticlesByType(HttpServletRequest request) {
        int type, page, start, totalPages, totalArticles;
        List<Article> articles;
        HashMap map = new HashMap();
        Response response = new Response();
        if (request.getParameter("type") == null) {
            return new Response(1, "参数错误");
        }
        type = Integer.parseInt(request.getParameter("type"));
        if (request.getParameter("page") == null) {
            page = 1;
        } else {
            page = Integer.parseInt(request.getParameter("page"));
        }
        start = (page - 1) * 10;
        try {
            articles = articleDao.getArticlesByType(type, start);
            totalArticles = articleDao.getArticlesByTypeNums(type);
            if (totalArticles % 10 == 0) {
                totalPages = totalArticles / 10;
            } else {
                totalPages = totalArticles / 10 + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
        map.put("totalPages", totalPages);
        map.put("articles", articles);
        response.setStatus(1);
        response.setMsg("获取成功");
        response.setBody(map);
        return response;
    }

    public Response updateArticleById(HttpServletRequest request, Article article) {
        Date date=new Date();
        HttpSession session=request.getSession();
        if (session.getAttribute("username")==null||session.getAttribute("portrait")==null){
            return new Response(1,"未登录");
        }
        if (article.getId()==0){
            return new Response(1,"未传入id");
        }
        article.setAddTime(date);
        article.setAuthorName((String)session.getAttribute("username"));
        article.setAuthorPortrait((String)session.getAttribute("portrait"));
        try{
            articleDao.updateArticleById(article);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(1,"数据库错误");
        }
        return new Response(0,"修改成功");
    }

}
