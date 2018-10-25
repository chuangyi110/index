package com.lzdn.tts;

import java.io.*;

public class DNA {
    //获取加密随机数值
    public static byte readFileFirstByte(String fileName){
        File file = new File(fileName);
        if(!file.exists()) return 0;
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        System.out.println(suffix);
        int first = 0;
        if(suffix.equals("jpg")){
            first = 0xff;
        }else if(suffix.equals("png")){
            first = 0x89;
        }
        RandomAccessFile randomAccessFile = null;
        int b= 0;
        try {
            randomAccessFile = new RandomAccessFile(fileName,"r");
            randomAccessFile.seek(0L);
            b = randomAccessFile.read();
            //一句话的解密过程。
            //b = (b-(first^0xff))&0xff;
            b = (b-(~first))&0xff;
            System.out.println(first);
            System.out.println("反位："+(first^0xff));
            System.out.println("差值:"+b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (byte)b;
    }
    public static String decrypt(String fileUrl, String tempUrl, int keyLength) throws Exception {
        File file = new File(fileUrl);
        if (!file.exists()) {
            return null;
        }
        File dest = new File(tempUrl);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        byte random = readFileFirstByte(fileUrl);
        InputStream is = new FileInputStream(fileUrl);
        OutputStream out = new FileOutputStream(tempUrl);

        byte[] buffer = new byte[1024];
        byte[] buffer2 = new byte[1024];
        byte bMax = (byte) 255;
        long size = file.length();
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
                //buffer2[i] = b == 0 ? bMax : --b;
                buffer2[i] = (byte)((b-random)^0xff);
            }
            out.write(buffer2, 0, r);
            k++;
        }
        //System.out.println("first："+readFileFirstByte(fileUrl));
        out.close();
        is.close();
        return tempUrl;
    }
    public static void main(String[] args) throws Exception {
        String filename = "铭牌（无码）_20170712035620.png";
        String filename2 = "timg4.png";
        decrypt("d:\\" + filename, "d:\\" + filename2, 6);

    }

}
