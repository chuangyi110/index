package com.lzdn.tts;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileUUID {

    /**
     * @param args
     * 测试主方法
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        long a = System.currentTimeMillis();
        System.out.println(getCurTime());
        lockImage("D:/timg.jpg", "D:/2.png", 111111);
        long b = System.currentTimeMillis();
        System.out.println(getCurTime());
        unLockImage("D:/2.png", "D:/timg2.jpg", 111111);
        long c = System.currentTimeMillis();
        System.out.println(getCurTime());
    }

    /**
     * * @param file_path	 *
     * 待加密的图片路径	 * @param save_path	 *
     * 加密后的图片路径	 * @param lock_num	 *
     * 加密密钥	 * @throws IOException
     */
    public static void lockImage(String file_path, String save_path,
                                 int lock_num) throws IOException {
        File soure = new File(file_path);
        File save = new File(save_path);
        lockImage(soure, save, lock_num);
    }

    /**
     * * @param file_path	 *
     * 待加密的图片文件	 * @param save_path	 *
     * 加密后的图片文件	 * @param lock_num	 *
     * 加密密钥	 * @throws IOException
     */
    public static void lockImage(File soure_file, File save_file, int lock_num)
            throws IOException {
        FileInputStream fis = new FileInputStream(soure_file);
        FileOutputStream fos = new FileOutputStream(save_file);
        int b = 0;
        int i = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b - lock_num);
            fos.flush();
        }
        fos.close();
        fis.close();
        System.out.println("加密完成");
    }
    public static void lockImagePlus(File soure_file, File save_file, int lock_num){
        byte[] tempbytes = new byte[5000];
        try {
            InputStream fis = new FileInputStream(soure_file);
            OutputStream fos = new FileOutputStream(save_file);
            int read;
            while ((read = fis.read()) > -1) {
                fos.write(read ^ lock_num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("******加密结束*****");
    }

    /**
     * * @param file_path	 *
     * 待解密的图片路径	 * @param save_path	 *
     * 解密后的图片路径	 * @param unlock_num	 *
     * 解密密钥	 * @throws IOException
     */
    public static void unLockImage(String file_path, String save_path,
                                   int unlock_num) throws IOException {
        File soure = new File(file_path);
        File save = new File(save_path);
        unLockImage(soure, save, unlock_num);
    }

    /**
     * @param soure_file	 *
     * 待解密的图片文件	 *
     * @param save_file	 *
     * 解密后的图片文件	 *
     * @param unlock_num	 *
     * 解密密钥	 * @throws IOException
     */
    public static void unLockImage(File soure_file, File save_file,
                                   int unlock_num) throws IOException {
        FileInputStream fis = new FileInputStream(soure_file);
        FileOutputStream fos = new FileOutputStream(save_file);
        int b = 0;
        while ((b = fis.read()) != -1) {
            fos.write(b + unlock_num);
            fos.flush();
        }
        fos.close();
        fis.close();
        System.out.println("解密完成");
    }
    public static String getCurTime(){
        Date d=new Date(System.currentTimeMillis());
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss:SSS");
        return df.format(d);
    }
}


