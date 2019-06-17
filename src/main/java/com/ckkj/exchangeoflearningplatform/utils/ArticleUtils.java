package com.ckkj.exchangeoflearningplatform.utils;


import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

/**
 * 文章工具类
 *
 * @author lzh
 * create 2019-06-15-22:02
 */
public class ArticleUtils {

    /**
     * 保存文章
     * @param userName
     * @param content
     * @param path
     * @return
     */
    public static String WriteStringToFile(String userName,String content,String path){


        try {
            FileWriter fw = new FileWriter(path, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(content);
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("写入失败");
        }

        return "写入成功";
    }

    /**
     * 读取文章
     * @param path
     * @return
     */
    public static String readArticleByPath(String path){

        String article = "";

        try {
            //1、建立连接
            InputStream is = new FileInputStream(path);
            //2、开始读取信息
            //is.available()：返回文件的大小
            byte[] b = new byte[is.available()];
            //完整的读取一个文件
            int off = 0;
            //int le = 2;
            while(is.read(b, off, 2)!=-1){
                off+=1;
            }
            is.read(b,off,2);
            System.out.print(new String(b));
            article += new String(b);

            //关闭流
            is.close();
        } catch (IOException e) {
            //文件读写异常
            e.printStackTrace();
        }

        return article;
    }

    /**
     * 文章简介
     *
     * @param article
     * @return
     */
    public static String articleIntroduce(String article){


        int bodyStart = article.indexOf("<body");
        int bodyEnd = article.indexOf("</body");
        String body = article.substring(bodyStart, bodyEnd);

        String conn = body.replaceAll("<([a-zA-Z]+( *)(\\.*))>","");
        int i = conn.indexOf("<", 0);
        String str = conn.substring(0,i);

        System.out.println(str);


        return str;
    }
}
