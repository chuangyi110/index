package com.lzdn.tts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

public class FileEncryptAndDecrypt4Web extends FileEncryptAndDecrypt {

    private final static Logger LOGGER = LoggerFactory.getLogger(FileEncryptAndDecrypt4Web.class);
    /**
     * web文件加密存储
     * @param file  web文件
     * @param req   request
     * @param key   加密密匙
     * @param random    随机命名
     * @throws Exception
     */
    public static FilePath encrypt(File file, HttpServletRequest req, String key, Boolean random){
        String webPath = req.getScheme()+"://"+req.getServerName()+":"
                +req.getServerPort()+req.getContextPath()+"/";
        String realPath=req.getSession().getServletContext().getRealPath("/")
                +File.separator+"upload"+File.separator+LocalDate.now()+File.separator;
        String randomStr = UUID.randomUUID().toString().replaceAll("-","");
        if(random){
            realPath = realPath+randomStr+"_"+file.getName();
            webPath = webPath+randomStr+"_"+file.getName();
        }else {
            realPath =realPath+file.getName();
            webPath = webPath+file.getName();
        }
        FilePath filePath =encrypt(file,key,realPath,webPath);
        return filePath;
    }
    /**
     * web文件加密存储 上传文件转换成加密文件
     * @param file  web文件
     * @param key   加密密匙
     * @param realPath  存储物理地址
     * @param webPath   存储网络地址
     * @return  FilePath
     * @throws Exception
     */
    public static FilePath encrypt(File file, String key,String realPath,String webPath){
        File dest = new File(realPath);
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new FileOutputStream(realPath);
            byte[] buffer = new byte[1024];
            byte[] buffer2 = new byte[1024];
            int r;
            while ((r=in.read(buffer))>0){
                for (int i = 0;i<r;i++){
                    byte b = buffer[i];
                    buffer2[i]=b==255 ? 0 : ++b;
                }
                out.write(buffer2,0,r);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        file.delete();
//        dest.renameTo(file);
        appendMethodA(dest,key);
        System.out.println("加密成功");
        return new FilePath(realPath,webPath);
    }
    /**
     * 解密 web端，将本地加密文件转换成解密byte[]
     * @param fileUrl
     * @param keyLength
     * @return 文件byte[]
     */
    public static byte[] decrypt(String fileUrl,int keyLength){
        File file = new File(fileUrl);
        if (!file.exists()) { return null; }
        InputStream is =null;
        ByteArrayOutputStream bout = null;
        try {
            is = new FileInputStream(fileUrl);
            bout = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            byte[] buffer2 = new byte[1024];
            byte  bMax = (byte) 255;
            long size = file.length() - keyLength;
            int mod = (int) (size % 1024);
            int div = (int) (size >> 10);
            int count = mod == 0 ? div : (div + 1);
            int k = 1, r;
            while ((k <= count && (r = is.read(buffer)) > 0)) {
                if (mod != 0 && k == count) {
                    r = mod;
                }
                for (int i = 0; i < r; i++) {
                    byte b = buffer[i];
                    buffer2[i] = b == 0 ? bMax : --b;
                }
                bout.write(buffer2,0,r);
                k++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bout.flush();
                is.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] picData = bout.toByteArray();
        return picData;
    }
    /**
     * byte[]解密测试
     * @param args
     */
    public static void main(String[] args) {
        String filename = "d:\\"+"冲田总司8k动漫壁纸_彼岸图网.jpg";
        String filename2 = "d:\\"+UUID.randomUUID()+".jpg";
        byte[] bytes = FileEncryptAndDecrypt4Web.decrypt(filename,6);
        File dir = new File(filename2);
        BufferedOutputStream bos = null;
        if(!dir.exists()&&dir.isDirectory()){
            dir.mkdirs();
        }
        try {
            bos = new BufferedOutputStream(new FileOutputStream(dir));
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件加密web
     * @param args
     */
//    public static void main(String[] args) {
//        File file = new File("D:\\timg2.jpg");
//        FileEncryptAndDecrypt4Web.encrypt(file,"jshsoft","d:\\9898.jpg","tt");
//    }
}
