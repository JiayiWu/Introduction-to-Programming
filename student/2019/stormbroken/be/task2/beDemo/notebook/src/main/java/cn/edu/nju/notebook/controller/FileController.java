package cn.edu.nju.notebook.controller;


import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * Created by Jiayiwu on 19/1/13.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@RestController
@RequestMapping("/file/")
public class FileController {

    @Value("${file.savePath}")
    private String savePath;

    @Autowired
    private FileService fileService;
    //来自swagger中的
    @ApiOperation(value = "上传文件", response = SimpleResponse.class,notes = "返回上传文件后文件指定的路径")
    @PostMapping("/upload")
    public SimpleResponse handleFileUpload(HttpSession session, @RequestParam("file") MultipartFile file) {
          if(session.getAttribute("user") == null){
            return SimpleResponse.error("Not login");
        }

        try{
            return SimpleResponse.ok(fileService.handleFileUpload(file, savePath));
        }catch (Exception e){
            return SimpleResponse.exception(e);
        }

    }


}
