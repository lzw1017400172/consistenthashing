package com.lzw.consistenthash;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by LZW on 2020/3/29.
 */
public class MyDataUtil {

    private static final String myDataPath = MyDataUtil.class.getResource("/").toString()+"mydata";

    public static void main(String[] args) throws IOException {
        System.out.println(myDataPath);
        //产生大量不重复的请求-key,序列化到本地重复使用
        Set<String> mydata = new HashSet<>();
        for(int i = 0;i<1000000;i++){
            Integer widgetId = (int)(Math.random() * 1000000);
            mydata.add("NO"+widgetId);
        }
        System.out.println("mydata size:"+mydata.size());
        MyDataUtil.write(mydata);




//反序列化
//        Object object = MyDataUtil.read();
//        Integer[] sss = (Integer[]) object;
    }

    /**
     * 对象序列化
     * @param object
     */
    public static void write(Object object){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\LZW\\Desktop\\work\\mydata");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对象反序列化
     * @return
     */
    public static Object read(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\Users\\LZW\\Desktop\\work\\mydata");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
