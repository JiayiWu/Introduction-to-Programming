package com.example.notebook2019.controller;

import com.example.notebook2019.constant.ServerException;
import com.example.notebook2019.constant.SimpleResponse;
import com.example.notebook2019.entity.UserEntity;
import com.example.notebook2019.form.AuthForm;
import com.example.notebook2019.service.SessionService;
import com.example.notebook2019.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by QinRuixin on 2019.6.11
 *
 */
@RestController
@RequestMapping("/session/")
public class SessionController {
    @Autowired
    SessionService sessionService;

    @ApiOperation(value = "用户登录",response = UserVO.class,notes = "返回SimpleResponse对象，如果登录成功，SimpleResponse对象Data为UserVO")
    @PostMapping("create")
    public SimpleResponse register(HttpSession session,@RequestBody AuthForm authForm){
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



}
