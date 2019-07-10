package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.form.DirForm;
import cn.edu.nju.notebook.service.DirService;
import cn.edu.nju.notebook.vo.DirTodoVO;
import cn.edu.nju.notebook.vo.DirVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/dir/")
public class DirController {

    @Autowired
    DirService dirService;

    @ApiOperation(value = "获取文件夹列表", response = DirVO.class)
    @GetMapping("list")
    public SimpleResponse getDirList(HttpSession httpSession) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            List<DirVO> dirVOList = dirService.getDirList(userEntity.getId());
            return SimpleResponse.ok(dirVOList);
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "添加文件夹", response = DirVO.class)
    @PostMapping("add")
    public SimpleResponse addDir(HttpSession httpSession, @RequestBody DirForm dirForm) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            DirEntity dirEntity = dirService.addDir(userEntity.getId(), dirForm);
            return SimpleResponse.ok(new DirVO(dirEntity));
        }
        catch (Exception e){
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除文件夹", response = SimpleResponse.class)
    @PostMapping("remove/{did}")
    public SimpleResponse removeDir(HttpSession httpSession, @RequestParam int did) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            dirService.removeDir(userEntity.getId(), did);
            return SimpleResponse.success();
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "获取文件夹下所有待办事项", response = DirTodoVO.class)
    @GetMapping("check/{did}")
    public SimpleResponse checkDir(HttpSession httpSession, @RequestParam int did) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            List<DirTodoVO> dirTodoVOList = dirService.checkDir(userEntity.getId(), did);
            return SimpleResponse.ok(dirTodoVOList);
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "添加待办事项到文件夹", response = SimpleResponse.class)
    @PostMapping("add/{did}/{tid}")
    public SimpleResponse addToDir(HttpSession httpSession, @RequestParam int did,  @RequestParam int tid) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            dirService.addToDir(userEntity.getId(), did, tid);
            return SimpleResponse.success();
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除文件夹的待办事项", response = SimpleResponse.class)
    @PostMapping("remove/{did}/{tid}")
    public SimpleResponse removeFromDir(HttpSession httpSession, @RequestParam int did,  @RequestParam int tid) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            dirService.removeFromDir(userEntity.getId(), did, tid);
            return SimpleResponse.success();
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }
}
