package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.model.Tests;
import com.ckkj.exchangeoflearningplatform.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;

/**
 * @author lzh
 * create 2019-04-30-17:47
 */

@Controller
public class TestController {


    @Autowired
    TestService testService;

    @GetMapping("/test/{id}")
    @ResponseBody
    public Tests testController(@PathVariable("id") Integer id) {
        Tests test = testService.findTest(id);
        System.out.println("test=" + test);
        return test;
    }

    @RequestMapping("/login")
    public String login() {

        return "login/login.html";
    }

    public ResponseEntity<FileSystemResource> export(File file) {
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".xls");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
    }

    @RequestMapping(value = "/dow", method = RequestMethod.GET)
    public ResponseEntity<FileSystemResource> exportXls() {
        return export(new File("\\\\\\192.168.87.130\\Users\\test.txt"));
    }

    //---------------------ROLE--------------------------------------------
    @GetMapping("/testone")
    @PreAuthorize("hasRole('USER')")
    public String test01() {
        return "testone";
    }

    @GetMapping("/testtwo")
    @PreAuthorize("hasRole('ADMIN')")
    public String test04() {
        return "testtwo";
    }

    @GetMapping("/page/test1/aa")
    public String test02() {
        return "/page/test1/aa";
    }

    @GetMapping("/page/test2/aa")
    public String test03() {
        return "/page/test1/bb";
    }

    //---------------------ROLE--------------------------------------------

    @GetMapping("/resource")
    public String resources() {
        System.out.println("share");
        return "resourceSha";
    }

    @GetMapping("/indextwos")
    public String ueditor() {
        System.out.println("indextwo.html");
        return "indextwo";
    }

}
