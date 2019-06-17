package com.ckkj.exchangeoflearningplatform.TestController;

import com.alibaba.fastjson.JSONObject;
import com.ckkj.exchangeoflearningplatform.mapper.VideoMapper;
import com.ckkj.exchangeoflearningplatform.model.Video;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
public class UploadController {

    @Autowired
    private VideoMapper videoMapper;

    @GetMapping("/upload")
    public String upload() {
        return "/test/Upload";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadVideos", method = RequestMethod.POST)
    public String uploadVideo(HttpServletRequest request) throws IOException {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String videoInfo = request.getParameter("videoInfo");
        Video video = JSONObject.parseObject(videoInfo, Video.class);
        String newPath = "D:" + File.separator + "视频" + File.separator;
        for (int i = 0; i < files.size(); i++) {
            MultipartFile multipartFile = files.get(i);
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));

            // MultipartFile转换为File
            File file = new File(newPath + "abc" + prefix);
            multipartFile.transferTo(file);

            FileInputStream readFile = new FileInputStream(file.getAbsolutePath());
            // 读取文件内容生成16位的md5
            String md5Name = DigestUtils.md5Hex(readFile);
            readFile.close();

            File newFile = new File(newPath + md5Name + prefix);
            boolean flag = file.renameTo(newFile);
            if (flag){
                video.setVideoPath(newFile.getAbsolutePath());
                // 将视频信息插入到数据库中
                int id = videoMapper.insertVideo(video);
                System.out.println(id);
                return "success";
            }
        }
        return "error";
    }
}
