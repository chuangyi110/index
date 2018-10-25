package com.lzdn.common.util;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class FileUtil {
    public static String[] typeImg = {"gif", "jpg", "png"};
    public static String[] typeVideo = {"mp4", "wmv"};
    public static String[] typeAutio = {"mp3", "wma"};

    /**
     *
     * @param req
     * @param pathDeposit 存放位置(路径)
     * @param file 文件
     * @param isRandomName 是否随机名称
     * @param defaultFileType 类型数组
     * @param fileType  文件类型
     * @return 完整文件路径
     */
    public static String upload(HttpServletRequest req, String pathDeposit, MultipartFile file, boolean isRandomName, String[] defaultFileType, String fileType) {
        //获取原文件名

       try{
           String initialName = file.getOriginalFilename();
           System.out.println("FileUtil.java 14:" + initialName);
           if (fileType != null) {
               boolean booIsType = false;
               for (String str : defaultFileType) {
                   if (str.equals(fileType)) {
                       booIsType = true;
                   }
               }
               if (booIsType) {
                   String path=getRootPath()+req.getContextPath()+pathDeposit;
                   System.out.println("FileUtil.java 24：" + path);
                   String fileSrc="";
                   if (isRandomName) {
                       initialName = LocalDate.now() + "-" + UUID.randomUUID().toString() + initialName.substring(initialName.lastIndexOf("."));
                   }

                   File targetFile = new File(path, initialName);
                   //判断文件目录是否存在
                   if (!targetFile.exists()) {
                       targetFile.mkdirs();
                   }
                   file.transferTo(targetFile);
                   fileSrc=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+req.getContextPath()+pathDeposit+initialName;
                   System.out.println("FileUtil.java 53：图片上传成功:"+fileSrc);
                   return fileSrc;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
       return "";
    }
    public static String getRootPath() {
        String classPath = Thread.currentThread().getContextClassLoader()
                .getResource("").getPath();
        String rootPath = "";

        /** For Windows */
        if ("\\".equals(File.separator)) {
            String path = classPath.substring(1,
                    classPath.indexOf("/WEB-INF/classes"));
            rootPath = path.substring(0, path.lastIndexOf("/"));
            rootPath = rootPath.replace("/", "\\");
        }

        /** For Linux */
        if ("/".equals(File.separator)) {
            String path = classPath.substring(0,
                    classPath.indexOf("/WEB-INF/classes"));
            rootPath = path.substring(0, path.lastIndexOf("/"));
            rootPath = rootPath.replace("\\", "/");
        }
        return rootPath;
    }
    public static String getWidthAndHeight(MultipartFile file){
        try{
            BufferedImage image = ImageIO.read(file.getInputStream());
            return image.getWidth()+"*"+image.getHeight();
        }catch (IOException e){
            e.fillInStackTrace();
            return "";
        }

    }
}