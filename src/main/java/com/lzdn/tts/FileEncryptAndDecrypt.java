package com.lzdn.tts;
/**
 * create by lz 2018/9/28
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.UUID;

public class FileEncryptAndDecrypt {
    private final static Logger LOGGER = LoggerFactory.getLogger(FileEncryptAndDecrypt.class);

    public static class FilePath{
        private String realPath,webPath;
        public FilePath(){ };
        public FilePath(String realPath,String webPath){
            this.realPath = realPath;
            this.webPath = realPath;
        }
        public String getRealPath() { return realPath; }
        public void setRealPath(String realPath){ this.realPath = realPath; }
        public String getWebPath(){ return webPath; }
        public void setWebPath(String webPath){ this.webPath =  webPath; }
    }
    /**
     * 文件file进行加密
     * @param fileUrl 文件路径
     * @param key  密码
     * @throws Exception
     */
    public static void encrypt(String fileUrl, String key) throws Exception {
        File file = new File(fileUrl);
        String path = file.getPath();
        if (!file.exists()) { return; }
        int index = path.lastIndexOf("\\");
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String destFile = path.substring(0, index) + "\\" + uuid;
        File dest = new File(destFile);
        InputStream in = new FileInputStream(fileUrl);
        OutputStream out = new FileOutputStream(destFile);
        byte[] buffer = new byte[1024];
        int r;
        byte[] buffer2 = new byte[1024];
        while ((r = in.read(buffer)) > 0) {
            for (int i = 0; i < r; i++) {
                byte b = buffer[i];
                buffer2[i] = b == 255 ? 0 : ++b;
            }
            out.write(buffer2, 0, r);
            out.flush();
        }
        in.close();
        out.close();
        file.delete();
        dest.renameTo(new File(fileUrl));
        appendMethodA(fileUrl, key);
        LOGGER.info("加密成功，新文件路径"+fileUrl);
    }
    /**
     *  添加密匙
     * @param fileUrl  文件路径
     * @param content  密钥
     */
    public static void appendMethodA(String fileUrl, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileUrl, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加密匙
     * @param file
     * @param content
     */
    public static void appendMethodA(File file,String content){
        try{
            RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
            long fileLength = randomAccessFile.length();
            System.out.println("fileLength"+fileLength);
            randomAccessFile.seek(fileLength);
            randomAccessFile.writeBytes(content);
            randomAccessFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 解密 ：将本地源文件解密到临时文件内
     *
     * @param fileUrl 源文件
     * @param tempUrl 临时文件
     * @param keyLength 密码长度
     * @return 解密后文件路径
     * @throws Exception
     */
    public static String decrypt(String fileUrl, String tempUrl, int keyLength) throws Exception {
        File file = new File(fileUrl);
        if (!file.exists()) {
            return null;
        }
        File dest = new File(tempUrl);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        InputStream is = new FileInputStream(fileUrl);
        OutputStream out = new FileOutputStream(tempUrl);

        byte[] buffer = new byte[1024];
        byte[] buffer2 = new byte[1024];
        byte bMax = (byte) 255;
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
                //正整数位
                //System.out.println(b&0xFF);
                buffer2[i] = b == 0 ? bMax : --b;
            }
            out.write(buffer2, 0, r);
            k++;
        }
        out.close();
        is.close();
        return tempUrl;
    }


    /**
     * 判断文件是否加密
     *
     * @param fileName
     * @return
     */
    public static String readFileLastByte(String fileName, int keyLength) {
        File file = new File(fileName);
        if (!file.exists())
            return null;
        StringBuffer str = new StringBuffer();
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            for (int i = keyLength; i >= 1; i--) {
                randomFile.seek(fileLength - i);
                str.append((char) randomFile.read());
            }
            randomFile.close();
            return str.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 本地文件测试
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String filename = "冲田总司8k动漫壁纸_彼岸图网.jpg";
        String filename2 = "timg4.jpg";
        String flag = readFileLastByte("d:\\" + filename, 6);
        if (flag.indexOf("hello") > 0) {
            // 加密过了;

            new FileEncryptAndDecrypt().decrypt("d:\\" + filename, "d:\\" + filename2, 6);

        } else {
            // 没有加密
            new FileEncryptAndDecrypt().encrypt("d:\\" + filename, "hello");
        }
        //System.out.println(readFileLastByte("d:\\timg.jpg", 6));

    }
    public static void fileEncryptAndDecrypt(String path,String filename,String key) throws Exception {
        String flag = readFileLastByte(path+filename,key.length()+1);
        if(flag.indexOf(key)>0){
            new FileEncryptAndDecrypt().decrypt(path+filename,path+"new_"+filename,key.length()+1);
        }else {
            new FileEncryptAndDecrypt().encrypt(path+filename,key);
        }
    }
}