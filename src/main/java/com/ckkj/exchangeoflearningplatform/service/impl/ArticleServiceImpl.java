package com.ckkj.exchangeoflearningplatform.service.impl;

import com.ckkj.exchangeoflearningplatform.mapper.ArticleMapper;
import com.ckkj.exchangeoflearningplatform.model.Article;
import com.ckkj.exchangeoflearningplatform.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章服务实现类
 *
 * @author lzh
 * create 2019-06-15-21:36
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }

    @Override
    public String findArticlePathByUserArticle(String userArticle,String title) {
        return articleMapper.findArticlePathByUserArticle(userArticle,title);
    }

    @Override
    public List<String> findAllTitle() {

        return articleMapper.findAllTitle();
    }

    @Override
    public List<Map<String, Object>> findArticleByNamePage(String userName,int currentPage, int size) {

        currentPage *= 10;

        List<Map<String, Object>> pagTitle = articleMapper.findArticleByNamePage(userName,currentPage, size);
        for (Map<String, Object> stringObjectMap : pagTitle) {
            Object id = stringObjectMap.get("id");
            Object userArticle = stringObjectMap.get("user_article");
            Object announce = stringObjectMap.get("announce");

            stringObjectMap.put("link","http://localhost:8080/wordIndex?id="+id);
            stringObjectMap.put("author",userArticle);
            stringObjectMap.put("date",announce);


            stringObjectMap.remove("id");
            stringObjectMap.remove("user_article");
            stringObjectMap.remove("announce");

        }

        return pagTitle;
    }

    @Override
    public Article findArticleById(int id) {
        Article article = articleMapper.findArticleById(id);
        article.setArticlePath("http://localhost:8080/static"+article.getArticlePath()+".html");
        return article;
    }

    @Override
    public List<Map<String, Object>> findAllArticle() {

        List<Map<String, Object>> allArticle = articleMapper.findAllArticle();
        for (Map<String, Object> stringObjectMap : allArticle) {
            Object id = stringObjectMap.get("id");
            Object userArticle = stringObjectMap.get("user_article");
            Object announce = stringObjectMap.get("announce");
            int integral = (int) stringObjectMap.get("integral");

            stringObjectMap.put("link","http://localhost:8080/wordIndex?id="+id+"&integral="+integral);
            stringObjectMap.put("author",userArticle);
            stringObjectMap.put("date",announce);


            stringObjectMap.remove("id");
            stringObjectMap.remove("user_article");
            stringObjectMap.remove("announce");

        }

        return allArticle;
    }

    @Override
    public String getPathById(int id) {
        return articleMapper.getPathById(id);
    }
}
