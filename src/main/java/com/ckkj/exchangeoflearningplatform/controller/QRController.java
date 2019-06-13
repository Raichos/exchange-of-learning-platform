package com.ckkj.exchangeoflearningplatform.controller;

import com.ckkj.exchangeoflearningplatform.utils.QRCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二维码处理
 *
 * @author lzh
 * create 2019-06-05-20:41
 */
@Controller
public class QRController {

    //private String ridcord = "phoneLogina";
    //private int count = 0;
    private String ridcord;

    @PostMapping("/lose/createQRCode")
    @ResponseBody
    public String createQRCode(@RequestParam("rid") String rid, HttpServletRequest request) {
        System.out.println("rid=" + rid);
        QRCodeUtil.qRCodeFactor(rid);
        ridcord = rid;

        //ServletContext servletContext = request.getServletContext();

        return "true";
    }

    //@ResponseBody
    @GetMapping("/getImg")
    public void getImg(/*@RequestParam("rid") String rid ,*/ HttpServletResponse response) throws IOException {
        System.out.println("getImg");
        /*if (this.count == 0){
            ridcord = "phoneLogin";
            this.count = 1;
        }*/
        //QRCodeUtil.qRCodeFactor(rid);

        OutputStream os = null;
        FileInputStream fis = null;
        try {
            response.setContentType("text/html; charset=UTF-8");
            response.setContentType("image/jpeg"); // 设置图片格式格式，这里可以忽略


            fis = new FileInputStream("F:/idea2018WorkSpace/exchange-of-learning-platform/src/main/resources/static/img/login/loginQRCode_" + ridcord+".jpg");
            os = response.getOutputStream();

            int count = 0;
            byte[] buffer = new byte[1024];
            while ((count = fis.read(buffer)) != -1)
                os.write(buffer, 0, count);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null)
                os.close();
            if (fis != null)
                fis.close();
        }
    }
}
