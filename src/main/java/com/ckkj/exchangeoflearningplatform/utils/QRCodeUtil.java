package com.ckkj.exchangeoflearningplatform.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Scanner;

/**
 * 二维码生成
 *
 * @author lzh
 * create 2019-06-03-15:12
 */
public class QRCodeUtil {


    //二维码颜色 、背景色
    //(注：二维码颜色色差大，扫描快，但如果"BLACK'设置为黑色外其他颜色，可能无法扫描  )
    //private static final int BLACK = 0xFF000000;
    private static final int RED =  0xFFFF0000;
    private static final int BLUE = 0x49c1f9;
    private static final int BLACK = 0x000000;
    private static final int WHITE = 0xFFFFFFFF;
    //二维码图片宽度 、高度
    private static final int width = 400;
    private static final int height = 400;
    //二维码格式参数
    private static final EnumMap<EncodeHintType, Object>
            hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
    static{
        /*二维码的纠错级别(排错率),4个级别：
         L (7%)、
         M (15%)、
         Q (25%)、
         H (30%)(最高H)
         纠错信息同样存储在二维码中，纠错级别越高，纠错信息占用的空间越多，那么能存储的有用讯息就越少；共有四级；
         选择M，扫描速度快。
         */
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 二维码边界空白大小 1,2,3,4 (4为默认,最大)
        hints.put(EncodeHintType.MARGIN, 0);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MAX_SIZE, 350);
        hints.put(EncodeHintType.MIN_SIZE, 150);
    }

    public static void writeToFile(String contents, String format, File file){
        BufferedImage image = encodeImg(contents);
        try {
            ImageIO.write(image, format, file);
        } catch (IOException e) {
            System.out.println("二维码写入文件失败"+e.getMessage());
        }
    }

    public static BufferedImage encodeImg(String contents){
        BufferedImage image = null;
        try{
            BitMatrix matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, height, hints);
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            for(int x = 0; x < width; x++){
                for(int y =0;y < height; y++){
                    image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
                }
            }
        }catch(Exception e){
            System.out.println("生成二维码失败"+e.getMessage());
        }
        return image;
    }

    public static void qRCodeFactor(String str){

        String path = Class.class.getClass().getResource("/").getPath();

        path = path.substring(1,path.indexOf("exchange-of-learning-platform")+"exchange-of-learning-platform".length()+1)+"src/main/resources/static/img/login/";

        String url = path+"loginQRCode_"+str+".jpg";
        str = "http://192.168.90.94:8080/phone?rid="+str;
        writeToFile(str, "png", new File(url));
        System.out.println("二位码已生成为 : "+ url);

    }

    /*public static void main(String[] args) {
        qRCodeFactor();
    }*/
}
