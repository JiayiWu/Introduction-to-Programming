package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.form.AuthForm;
import cn.edu.nju.notebook.service.SessionService;
import cn.edu.nju.notebook.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Jiayiwu on 19/5/2.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@RestController
@RequestMapping("/session/")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @ApiOperation(value = "用户登录", response = UserVO.class,notes = "返回SimpleResponse对象，如果登录成功，SimpleResponse对象Data为UserVO")
    @PostMapping("create")
    public SimpleResponse register(HttpSession session, @RequestBody AuthForm authForm){
        UserEntity userEntity;
        try {
            userEntity = sessionService.login(authForm.getEmail(),authForm.getPassword());
            session.setAttribute("user",userEntity);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            return SimpleResponse.error("Server Login error");
        }

        return SimpleResponse.ok(new UserVO(userEntity));
    }

    @ApiOperation(value = "用户退出登录", response = SimpleResponse.class)
    @PostMapping("destroy")
    public SimpleResponse modifyPassword(HttpSession session)
    {
        session.setAttribute("user",null);
        return SimpleResponse.ok("Success");
    }

    @ApiOperation(value = "获取当前登录用户信息", response = UserVO.class,notes = "返回SimpleResponse对象，如果当前用户已经登录，则SimpleResponse对象Data为UserVO")
    @GetMapping("info")
    public SimpleResponse getUserInfo(HttpSession session){
        Object userInfo = session.getAttribute("user");

        if (userInfo == null) {
        return SimpleResponse.error("Not login");
        }
        return SimpleResponse.ok(new UserVO((UserEntity)userInfo));
    }
}
