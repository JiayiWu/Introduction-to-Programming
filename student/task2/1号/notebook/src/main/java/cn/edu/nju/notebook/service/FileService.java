package cn.edu.nju.notebook.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created on 2019/1/16
 */
public interface FileService {

    /**
     * 文件上传接口
     * @param file file
     * @param directory 相对于static文件夹的文件目录路径 例如文件最终存储在static/img/1.png，则参数为 img
     * @return 相对路径，如文件完整路径为 localhost:8181/img/1.png，则返回 img/1.png
     */
    String handleFileUpload(MultipartFile file, String directory) throws Exception;

    boolean deleteOldFile(String oldPath) throws Exception;
}
