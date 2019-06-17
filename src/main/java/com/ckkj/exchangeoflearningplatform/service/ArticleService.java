package com.ckkj.exchangeoflearningplatform.service;

import com.ckkj.exchangeoflearningplatform.model.Article;

import java.util.List;
import java.util.Map;

/**
 * @author lzh
 * create 2019-06-15-21:36
 */
public interface ArticleService {

    /**
     * 添加文章
     * @param article
     * @return
     */
    int addArticle(Article article);

    /**
     * 通过作者查找文章路径
     *
     * @param userArticle
     * @param title
     * @return
     */
    String findArticlePathByUserArticle(String userArticle,String title);

    /**
     * 查找所有标题
     *
     * @return
     */
    List<String > findAllTitle();

    /**
     * 分页查询标题
     *
     * @param userName
     * @param currentPage
     * @param size
     * @return
     */
    List<Map<String, Object>> findArticleByNamePage(String userName,int currentPage, int size);

    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    Article findArticleById(int id);

    /**
     * 查询所有文章
     * @return
     */
    List<Map<String, Object>> findAllArticle();

    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    String getPathById(int id);
}
