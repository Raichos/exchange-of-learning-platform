package com.ckkj.exchangeoflearningplatform.mapper;

import com.ckkj.exchangeoflearningplatform.model.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 文章Mapper
 *
 * @author lzh
 * create 2019-06-15-21:02
 */
@Mapper
public interface ArticleMapper {

    /**
     * 文章添加
     * @param article
     * @return
     */
    @Insert("INSERT INTO article (user_article,title,article_path,announce) VALUES (#{userArticle},#{title},#{articlePath},#{announce})")
    int addArticle(Article article);

    /**
     * 通过文章作者名和标题查找文章
     * @param userArticle
     * @return
     */
    @Select("SELECT article_path FROM article WHERE user_article = #{userArticle} AND title = #{title}")
    String findArticlePathByUserArticle(String userArticle,String title);

    /**
     * 查找所有文章标题
     * @return
     */
    @Select("SELECT title FROM article")
    List<String> findAllTitle();

    /**
     * 分页查询标题
     *
     * @param currentPage
     * @param size
     * @return
     */
    @Select("SELECT id,user_article,title,article_path,announce,brief FROM article WHERE user_article = #{userName} LIMIT #{currentPage},#{size}")
    List<Map<String ,Object>> findPagTitle(String userName,int currentPage, int size);
}
