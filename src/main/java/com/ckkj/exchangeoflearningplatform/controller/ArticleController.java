package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.Article;
import com.ckkj.exchangeoflearningplatform.service.ArticleService;
import com.ckkj.exchangeoflearningplatform.utils.ArticleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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

        path = path.substring(1, path.indexOf("exchange-of-learning-platform") + "exchange-of-learning-platform".length() + 1) + "src/main/resources/static/article/" + userArticle + "_" + uuid+".html";
        Article article = new Article().setUserArticle(userArticle).setTitle(title).setAnnounce(new Date()).setArticlePath("/article/" + userArticle + "_" + uuid);
        ArticleUtils.WriteStringToFile(userArticle, artcle, path);

        String content = ArticleUtils.articleIntroduce(artcle);
        if (content.length() > 127){
            content = content.substring(0,127);
        }
        article.setBrief(content);

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

    /**
     * 根据id查找文章
     *
     * @param id
     * @return
     */
    @GetMapping("/getArticleById")
    @ResponseBody
    public Article getArticleById(@RequestParam("id") int id){

        Article article = articleService.findArticleById(id);
        article.setAnnounce(new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(article.getAnnounce())));

        return article;
    }

    /**
     * 通过文章id查找文章并返回json数据
     * @param id
     * @return
     */
    @GetMapping("/getContent")
    @ResponseBody
    public String getContent(@RequestParam("id") int id){


        String path1 = Class.class.getClass().getResource("/").getPath();
        path1 = path1.substring(1, path1.indexOf("exchange-of-learning-platform") + "exchange-of-learning-platform".length() + 1) + "src/main/resources/static";

        String path2 = articleService.getPathById(id);

        path2 = path1+path2+".html";

        String content = ArticleUtils.readArticleByPath(path2);

        return content;
    }

    /**
     * 查询所有文章
     * @return
     */
    @GetMapping("/getAllArticle")
    @ResponseBody
    public List<Map<String, Object>> getAllArticle(){

        List<Map<String, Object>> articles = articleService.findAllArticle();


        return articles;
    }

    /*@GetMapping("/static/article/{article}")
    public String articlePage(@PathVariable String article){

        System.out.println("article="+article);

        return "article/aaaa";
    }*/

}
