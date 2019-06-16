package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.Article;
import com.ckkj.exchangeoflearningplatform.service.ArticleService;
import com.ckkj.exchangeoflearningplatform.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 文章视图
 *
 * @author lzh
 * create 2019-06-15-21:41
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;

    /**
     * 文章添加
     *
     * @param userArticle
     * @param title
     * @param artcle
     * @return
     */
    @PostMapping("/addArticle")
    @ResponseBody
    public String addArticle(@RequestParam("userArticle") String userArticle, @RequestParam("title") String title, @RequestParam("artcle") String artcle) {
        //public String addArticle(Article article){

        String path = Class.class.getClass().getResource("/").getPath();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        path = path.substring(1, path.indexOf("exchange-of-learning-platform") + "exchange-of-learning-platform".length() + 1) + "src/main/resources/static/article/" + userArticle + "_" + uuid+".txt";
        Article article = new Article().setUserArticle(userArticle).setTitle(title).setAnnounce(new Date()).setArticlePath("/article/" + userArticle + "_" + uuid);
        ArticleUtils.WriteStringToFile(userArticle, artcle, path);

        int i = articleService.addArticle(article);
        if (i == 1) {

            return "上传成功";
        } else {
            return "上传失败";
        }
    }

    /**
     * 通过文章作者和标题查找文章
     *
     * @param userArticle
     * @param title
     * @return
     */
    @PostMapping("/readArticle")
    @ResponseBody
    public String readArticle(@RequestParam("userArticle") String userArticle, @RequestParam("title") String title) {

        String articleData = "";

        String path1 = Class.class.getClass().getResource("/").getPath();
        path1 = path1.substring(1, path1.indexOf("exchange-of-learning-platform") + "exchange-of-learning-platform".length() + 1) + "src/main/resources/static";

        String path2 = articleService.findArticlePathByUserArticle(userArticle, title);

        if (path2 == null) {
            return "没有找到该文章";
        }

        path2 = path1 + path2;

        String article = ArticleUtils.readArticleByPath(path2);

        return article;

    }

    /**
     * 查找所有标题
     *
     * @return
     */
    @PostMapping("/findAllTitle")
    @ResponseBody
    public List<String> findAllTitle(){

        List<String> titles = articleService.findAllTitle();

        return titles;
    }

    /**
     * 分页查询文章标题
     *
     * @param currentPage
     * @return
     */
    @GetMapping("/getWordTitleJson")
    @ResponseBody
    public List<Map<String, Object>> getWordTitleJson(@RequestParam("userName") String userName, @RequestParam("currentPage") int currentPage){

        System.out.println("currentPage="+currentPage);

        List<Map<String, Object>> articles = articleService.findPagTitle(userName,currentPage,10);

        return articles;
    }
}
