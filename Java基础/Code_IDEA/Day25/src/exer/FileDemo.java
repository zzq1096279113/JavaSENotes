package exer;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author zzq
 * @creat 2020-05-31 14:40
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("F:\\学习\\体育\\体育.pptx");
        File file1 = new File(file.getParent(), "haha.txt");
        file1.createNewFile();
    }


    @Test
    public void test2() {
        File file = new File("F:\\学习\\操作系统\\作业");
        String[] list = file.list();
        for (String s : list) {
            if(s.endsWith(".jpg"))
                System.out.println(s);
        }
    }


    @Test
    public void test3(){
        File file = new File("F:\\学习\\操作系统\\作业");
        int directorySize = getDirectorySize(file);
        System.out.println(directorySize);
    }

    private void print(File file) {
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                print(f);
            }else{
                System.out.println(f.getName());
            }
        }
    }

    public int getDirectorySize(File file){
        int size = 0;
        if(file.isFile()){
            size += file.length();
        }else{
            File[] files = file.listFiles();
            for(File f : files){
                size += getDirectorySize(f);
            }
        }
        return size;
    }
}
