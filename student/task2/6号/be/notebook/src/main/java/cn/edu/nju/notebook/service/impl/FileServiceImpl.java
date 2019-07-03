package cn.edu.nju.notebook.service.impl;


import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.service.FileService;
import cn.edu.nju.notebook.util.FileOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;

/**
 * Created on 2019/1/16
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.maxUploadSizeMB}")
    private int maxUploadSize;



    @Override
    public String handleFileUpload(MultipartFile file, String directory)
            throws Exception {

        if(file.isEmpty()){
            throw new ServerException(ResponseCode.Error,"Files cannot be empty");
        }
        if(file.getSize() > maxUploadSize*1024*1024){
            throw new ServerException(ResponseCode.Error,"File size should not exceed"+maxUploadSize+"M");
        }

        int index = file.getOriginalFilename().lastIndexOf(".");
        String suffix = file.getOriginalFilename().substring(index);
        String contextPath = FileOptions.getContextPath();
        String randomName = FileOptions.getRandomName();
        String saveFileName = Paths.get(contextPath,directory,randomName+suffix)
                .toString();
        File saveFile = new File(saveFileName);
        while(saveFile.exists()){
            randomName = FileOptions.getRandomName();
            saveFileName = Paths.get(contextPath,directory,randomName+suffix)
                    .toString();
            saveFile = new File(saveFileName);
        }
        File parentFile = saveFile.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        file.transferTo(saveFile);
        return directory+"/"+randomName+suffix;

    }

    @Override
    public boolean deleteOldFile(String oldPath) throws Exception {
        if (oldPath == null) {
            return true;
        }
        String relativePath = oldPath;
        if (oldPath.startsWith("http")) {
            String[] urlArr = oldPath.split("/");
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 2; i < urlArr.length; i++) {
                stringBuilder.append(urlArr[i]);
                if (i != urlArr.length - 1) {
                    stringBuilder.append("/");
                }
            }
            relativePath = stringBuilder.toString();
        }
        String contextPath = FileOptions.getContextPath();
        File oldFile = Paths.get(contextPath, relativePath).toFile();
        return !oldFile.exists() || oldFile.delete();

    }

}
