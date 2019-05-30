package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ldb on 2017/4/9.
 */
@Controller
public class UEditorController {


    /*@RequestMapping("/")
    private String showPage(){
        return "index";
    }*/

    @RequestMapping(value="/static/config")
    public void config(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("文件上传");
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("rootPath"+rootPath);
        try {
            String exec = new ActionEnter(request, rootPath).exec();
            System.out.println("exec"+exec);
            PrintWriter writer = response.getWriter();
            writer.write(exec);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("出错了");
            e.printStackTrace();
        }

    }
}
