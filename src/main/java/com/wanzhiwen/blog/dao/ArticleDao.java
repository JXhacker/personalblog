package com.wanzhiwen.blog.dao;

import com.wanzhiwen.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wanzhiwen
 * @time 2018/11/14
 */
@Repository
public interface ArticleDao {
    void insertArticle(Article article);

    Article getArticleById(int id);

    List<Article> getArticlesByType(@Param("type") int type, @Param("subType") int subType, @Param("start") int start);

    int getArticlesByTypeNums(@Param("type") int type, @Param("subType") int subType);

    void updateArticleById(Article article);

    void addview(int articleId);
}
