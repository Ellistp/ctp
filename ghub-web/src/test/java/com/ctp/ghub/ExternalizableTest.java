package com.ctp.ghub;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author chengtianping
 * @description
 * @date 2018/6/12
 */
public class ExternalizableTest {

    public static void main(String[] args){
        File testFile = new File("D:\\test\\test1.txt");
        try {
            Test2DO testDO2 = new Test2DO(1L,"张三的歌","男");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(testFile));
            objectOutputStream.writeObject(testDO2);
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(testFile));
            Test2DO newTestDO = (Test2DO) objectInputStream.readObject();
            System.out.println(newTestDO.toString());
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
