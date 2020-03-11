package com.ac.guava.io;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

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
            HashCode fromHash = Files.asByteSource(from).hash(Hashing.sha256());
            HashCode targetHash = Files.asByteSource(target).hash(Hashing.sha256());
            System.out.println(fromHash.equals(targetHash));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //jdk nio包下 拷贝文件
    @Test
    public void testCopyFileWitchJDKNio2(){
        try {
            Path copy = java.nio.file.Files.copy(
                    Paths.get("D:\\1program_soft\\anchao_test_project\\leader\\src\\test\\resources","io","source.txt"),
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

    //读取文本内容
    @Test
    public void testToString(){
        String str ="hello guava files";
        try {
            List<String> stringList = Files.readLines(new File(SOURCE_FILE), Charsets.UTF_8);
            System.out.println(stringList);
            String join = Joiner.on("\n").join(stringList);
            System.out.println(join);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //灵活读取文件内容
    @Test
    public void testToProcessString(){
        try {
            LineProcessor<List> lineProcessor = new LineProcessor<List>() {

                List<Integer> list =  new ArrayList();
                @Override
                public boolean processLine(String line) throws IOException {
                    list.add(line.length());
                    return true;
                }
                @Override
                public List<Integer> getResult() {
                    return list;
                }
            };
            Files.asCharSource(new File(SOURCE_FILE),Charsets.UTF_8).readLines(lineProcessor);
            System.out.println(lineProcessor.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取文件hash值
    @Test
    public  void testFileMd5(){
        File file = new File(SOURCE_FILE);
        try {
          //  Files.hash(file, Hashing.goodFastHash(128));
            HashCode hash = Files.asByteSource(file).hash(Hashing.sha256());
            System.out.println(hash.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //持续 向文件写 再读
    @Test
    public void testFileWrite(){
        String str = "\ntest files write";
        try {
            File file = new File(SOURCE_FILE);
            //file.deleteOnExit();
            Files.asCharSink(file,Charsets.UTF_8, FileWriteMode.APPEND).write(str);
            String read = Files.asCharSource(file, Charsets.UTF_8).read();
            System.out.println(read);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //touch 创建文件
    @Test
    public void testTouchFile(){
        File file = new File("D:\\1program_soft\\anchao_test_project\\leader\\src\\test\\resources/io/touch.doc");
        try {
            Files.touch(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //递归文件地址
    @Test
    public void testRecursive(){
        ArrayList<File> arrayList = Lists.newArrayList();
        File file = new File("D:\\1program_soft\\anchao_test_project\\leader\\src\\main\\java\\com\\ac");
        recursive(arrayList,file);
        arrayList.forEach(System.out::println);
    }


    //递归
    private void recursive(ArrayList<File>  fileArrayList,File fe){
        if (fe.isHidden()) {
            return;
        }
        if (!fe.isFile()) {
            fileArrayList.add(fe);
            File[] files = fe.listFiles();
            for(File f:files){
                recursive(fileArrayList,f);
            }
        }

    }

    //转换流(FluentIterable) 正着遍历
    @Test
    public void testTreeFilesPreOrderTraversal(){
        File root = new File("D:\\1program_soft\\anchao_test_project\\leader\\src\\main");
        FluentIterable<File> filter = Files.fileTreeTraverser().preOrderTraversal(root).filter(File::isFile);
        filter.forEach(System.out::println);

    }



    //转换流(FluentIterable) 倒着遍历
    @Test
    public void testTreeFilesPostOrderTraversal(){
        File root2 = new File("D:\\1program_soft\\anchao_test_project\\leader\\src\\main");
        FluentIterable<File> filter2 = Files.fileTreeTraverser().postOrderTraversal(root2).filter(File::isFile);
        filter2.forEach(System.out::println);

    }


    //转换流(FluentIterable) 按目录长度 自然顺序遍历
    @Test
    public void testTreeFilesBreadthFirstTraversal(){
        File root2 = new File("D:\\1program_soft\\anchao_test_project\\leader\\src\\main");
        FluentIterable<File> filter2 = Files.fileTreeTraverser().breadthFirstTraversal(root2).filter(File::isFile);
        filter2.forEach(System.out::println);
    }


    //取出所有子目录
    @Test
    public void testTreeFilesChild(){
        File root2 = new File("D:\\1program_soft\\anchao_test_project\\leader\\src\\main");
        Iterable<File> children = Files.fileTreeTraverser().children(root2);
        //D:\1program_soft\anchao_test_project\leader\src\main\java
        //D:\1program_soft\anchao_test_project\leader\src\main\resources
        children.forEach(System.out::println);
    }








//
//    @After
//    public void tearDown(){
//        File target = new File(TARGET_FILE);
//        if (target.exists()) {
//            target.delete();
//        }
//    }
}
