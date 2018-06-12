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
public class SerializableTest {

    public static void main(String[] args){
        File testFile = new File("D:\\test\\test.txt");
        try {
            TestDO testDO = new TestDO(1L,"张三的歌","男");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(testFile));
            objectOutputStream.writeObject(testDO);
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(testFile));
            TestDO newTestDO = (TestDO) objectInputStream.readObject();
            System.out.println(newTestDO.toString());
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
