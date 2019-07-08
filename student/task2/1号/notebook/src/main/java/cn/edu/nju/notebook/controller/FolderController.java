package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.FolderEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.form.FolderForm;
import cn.edu.nju.notebook.service.FolderService;
import cn.edu.nju.notebook.vo.FolderVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/folder")
public class FolderController {
    @Autowired
    FolderService folderService;

    @ApiOperation(value = "新建文件夹", response = FolderVO.class, notes = "返回SimpleResponse对象，如果新建成功，SimpleResponse对象Data为FolderVO")
    @PostMapping("/add")
    public SimpleResponse addFolder(HttpSession session, @RequestBody FolderForm folderForm) {

        if (session.getAttribute("user") == null) {
            return SimpleResponse.error("Not login");
        }

        if (folderForm.getName() == null || folderForm.getName().equals("")) {
            return SimpleResponse.error("文件夹名字不能为空");
        }

        FolderEntity folderEntity;
        try {
            UserEntity userEntity = (UserEntity) session.getAttribute("user");
            folderEntity = folderService.saveFolder(userEntity.getId(), folderForm.getName());
        } catch (Exception ex) {
            return SimpleResponse.exception(ex);
        }
        return SimpleResponse.ok(new FolderVO(folderEntity));
    }


    @ApiOperation(value = "删除文件夹", response = SimpleResponse.class)
    @PostMapping("/del")
    public SimpleResponse delFolder(HttpSession session, @RequestBody FolderForm folderForm) {

        if (session.getAttribute("user") == null) {
            return SimpleResponse.error("Not login");
        }

//        if(folderForm.getName().equals("默认文件夹")){
//            return SimpleResponse.error("默认文件夹不能删除");
//        }

        FolderEntity folderEntity = null;
        try {
            UserEntity userEntity = (UserEntity) session.getAttribute("user");
            folderService.delFolder(userEntity.getId(), folderForm.getName());
        } catch (Exception ex) {
            return SimpleResponse.exception(ex);
        }

        return SimpleResponse.ok("Succeed");
    }


    @ApiOperation(value = "修改文件夹", response = FolderVO.class, notes = "返回SimpleResponse对象，如果修改成功，SimpleResponse对象Data为FolderVO")
    @PostMapping("/update/{folderId}")
    public SimpleResponse changeFolder(HttpSession session, @PathVariable("folderId") Integer folderId, @RequestBody FolderForm folderForm) {

        if (session.getAttribute("user") == null) {
            return SimpleResponse.error("Not login");
        }

        if (folderForm.getName() == null || folderForm.getName().equals("")) {
            return SimpleResponse.error("新文件夹名字不能为空");
        }

        FolderEntity folderEntity ;
        try {
            UserEntity userEntity = (UserEntity) session.getAttribute("user");
            folderEntity = folderService.updateFolder(userEntity.getId(), folderId, folderForm.getName());
        } catch (Exception ex) {
            return SimpleResponse.exception(ex);
        }
        return SimpleResponse.ok(new FolderVO(folderEntity));
    }


    @ApiOperation(value = "获取该用户所有文件夹", response = List.class, notes = "返回SimpleResponse对象，如果当前用户已经登录，则SimpleResponse对象Data为包含FolderEntity的数组")
    @GetMapping("/all")
    public SimpleResponse getFolders(HttpSession session) {

        Object userInfo = session.getAttribute("user");

        if (userInfo == null) {
            return SimpleResponse.error("Not login");
        }

        List<FolderEntity> folders ;
        try {
            folders = folderService.getFolders(((UserEntity) userInfo).getId());
        } catch (Exception ex) {
            return SimpleResponse.exception(ex);
        }

        return SimpleResponse.ok(folders);

    }




}
