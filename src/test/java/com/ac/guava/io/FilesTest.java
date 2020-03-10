package com.ac.guava.io;

import com.google.common.io.Files;
import org.junit.After;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author anchao
 * @date 2020/3/10 16:39
 */
public class FilesTest {

    private final String SOURCE_FILE="D:\\1program_soft\\anchao_test_project\\leader\\src\\test\\resources/io/source.txt";
    private final String TARGET_FILE="D:\\1program_soft\\anchao_test_project\\leader\\src\\test\\resources/io/target.txt";

    //拷贝文件
    @Test
    public void testCopyFileWitchGuava(){
        File from = new File(SOURCE_FILE);
        File target = new File(TARGET_FILE);

        try {
            Files.copy(from,target);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //jdk nio包下 拷贝文件
    @Test
    public void testCopyFileWitchJDKNio2(){
        try {
            Path copy = java.nio.file.Files.copy(
                    Paths.get("D:\\1program_soft\\anchao_test_project\\leader\\src\\test\\resources/","io","source.txt"),
                    Paths.get("D:\\1program_soft\\anchao_test_project\\leader\\src\\test\\resources","io","source2.txt"),
                    StandardCopyOption.REPLACE_EXISTING
            );
            System.out.println(copy.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //移动文件
    @Test
    public void  testMove(){
        File from = new File(SOURCE_FILE);
        File target = new File(TARGET_FILE);
        try {
            Files.move(from,target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @After
    public void tearDown(){
        File target = new File(TARGET_FILE);
        if (target.exists()) {
            target.delete();
        }
    }
}
