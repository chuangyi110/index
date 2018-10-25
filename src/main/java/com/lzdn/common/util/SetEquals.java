package com.lzdn.common.util;

public class SetEquals {

    public static boolean stringEquals(String str1 ,String str2){
        if(SetEquals.stringEqual(str1,str2)) {
            return SetEquals.stringEqual(str2,str1);
        }else{
            return false;
        }
    }
    public static boolean stringEqual(String str1,String str2){
        String[] arr1,arr2;
        int L1 = str1.length();
        int L2 = str2.length();
        if(L1!=L2){
            return false;
        }
        arr1 = new String[L1];
        arr2 = new String[L2];
        for(int i=0;i<L1;i++){
            arr1[i] = str1.substring(i,i+1);
            arr2[i] = str2.substring(i,i+1);
        }
        boolean b = false;
        for(int i=0;i<L1;i++){
            String str = arr1[i];
            b =tt(arr2,str);
            if(!b){
                return b;
            }
            System.out.println(str+"__"+b);
        }
        return b;
    }
    public static boolean tt(String[] arr2,String str) {

        for (String s : arr2) {
            if (str.equals(s)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String c = "abc";
        String a = "abcd";
        boolean b  = SetEquals.stringEquals(a,c);
        System.out.println(b);
    }
}
