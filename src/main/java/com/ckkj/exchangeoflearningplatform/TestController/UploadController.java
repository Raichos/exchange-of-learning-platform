package com.ckkj.exchangeoflearningplatform.TestController;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
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

    @GetMapping("/upload")
    public String upload() {
        return "/test/Upload";
    }

    @ResponseBody
    @RequestMapping(value = "/uploadVideos", method = RequestMethod.POST)
    public String uploadVideo(HttpServletRequest request) throws IOException {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        // 文章标题
        String videoTitle = request.getParameter("VideoTitle");
        // 文章id
        int titleId = Integer.valueOf(request.getParameter("TitleId")) ;
        String newPath = "D:" + File.separatorChar;
        for (int i = 0; i < files.size(); i++) {
            MultipartFile multipartFile = files.get(i);
            // 获取文件名
            String fileName = multipartFile.getOriginalFilename();
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            String videoPath = "C:\\临时视频保存处\\";
            // MultipartFile转换为File
//            File file = File.createTempFile("abc", prefix, new File(videoPath));
            File file = new File(newPath + "abc" + prefix);
            multipartFile.transferTo(file);

            FileInputStream readFile = new FileInputStream(file.getAbsolutePath());

            String md5Name = DigestUtils.md5Hex(readFile);
            readFile.close();

            File newFile = new File(newPath + md5Name + prefix);
            boolean flag = file.renameTo(newFile);
            System.out.println(flag);
        }
        return "success";
    }
//    @ResponseBody
//    @RequestMapping(value = "/apk_upload", method = RequestMethod.POST)
//    public Map<String, Object> uploadApkFile(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        request.setCharacterEncoding("UTF-8");
//
//        Map<String, Object> json = new HashMap<String, Object>();
//        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//
//        /** 页面控件的文件流* */
//        MultipartFile multipartFile = null;
//        Map map = multipartRequest.getFileMap();
//        for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
//            Object obj = i.next();
//            multipartFile = (MultipartFile) map.get(obj);
//
//        }
//        /** 获取文件的后缀* */
//        String filename = multipartFile.getOriginalFilename();
//
//        InputStream inputStream;
//        String path = "";
//        String newVersionName = "";
//        String fileMd5 = "";
//        try {
//
//            inputStream = multipartFile.getInputStream();
//            File tmpFile = File.createTempFile(filename,
//                    filename.substring(filename.lastIndexOf(".")));
//            fileMd5 = Files.hash(tmpFile, Hashing.md5()).toString();
//            FileUtils.copyInputStreamToFile(inputStream, tmpFile);
//            // 上传UpYun后返回的path
//            String versionGbk = AnalysisApk.unZip(tmpFile.getPath(), "")[0];
//            byte[] versionNam = versionGbk.getBytes("iso8859-1");// 这里写转换前的编码方式
//            newVersionName = new String(versionNam, "utf-8");// 这里写转换后的编码方式
//            path = UpyunUtils.uploadApk(tmpFile,
//                    multipartFile.getOriginalFilename(), true, newVersionName);
//            System.err.println(path);
//            tmpFile.delete();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        json.put("newVersionName", newVersionName);
//        json.put("fileMd5", fileMd5);
//        json.put("message", "应用上传成功");
//        json.put("status", true);
//        json.put("filePath", path);
//        return json;
}
