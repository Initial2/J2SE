package File.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author initial
 * @create 2021-03-07 17:37
 */
public class FileExer {

    /*
      1. 创建一个File对象, 在其中创建多个文件
      2. 编写方法,实现删除file中的指定文件
        */
    @Test
    public void test1() throws IOException {
        File file;
        for (int i = 1; i <= 10 ; i++) {
            String fileName = i+".txt";
            file = new File("C:\\Users\\Inital\\Desktop\\"+fileName);
            boolean newFile = file.createNewFile();
            System.out.println(newFile);
        }
    }
    @Test
    public void  deleteFile(){
        String fileName = "2.txt";
        File file  = new File("C:\\Users\\Inital\\Desktop\\"+fileName);
        if (file.exists()){
            file.delete();
        }else{
            System.out.println("文件不存在");
        }
    }

}
