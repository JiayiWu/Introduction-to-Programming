package cn.edu.nju.notebook.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created on 2019/1/16
 */
public class FileOptions {

    public static String getContextPath() throws FileNotFoundException {

        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!path.exists()){
            path = new File("");
        }
        return Paths.get(path.getAbsolutePath(),"static").toString();
    }

    public static String getRandomName(){
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        Random random = new Random();
        int ranNum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
        return ranNum + str;
    }

}
