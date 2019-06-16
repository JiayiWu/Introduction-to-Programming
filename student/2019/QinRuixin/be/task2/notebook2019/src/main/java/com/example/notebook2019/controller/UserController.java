package com.example.notebook2019.controller;

import com.example.notebook2019.constant.ServerException;
import com.example.notebook2019.constant.SimpleResponse;
import com.example.notebook2019.entity.UserEntity;
import com.example.notebook2019.form.UserForm;
import com.example.notebook2019.service.UserService;
import com.example.notebook2019.vo.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;
    @ApiOperation(value = "用户注册",response = UserVO.class,notes = "返回SimpleResponse对象，如果成功注册，则SimpleResponse对象Data为UserVO")

    @PostMapping("account")
    public SimpleResponse register(HttpSession session, @RequestBody UserForm userForm){

        UserEntity userEntity;
        try {
            userEntity = userService.createUser(userForm);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException);
        }catch (Exception e) {
            e.printStackTrace();
            return SimpleResponse.error("Create user error");
        }
        session.setAttribute("user",userEntity);
        return SimpleResponse.ok(new UserVO(userEntity));
    }


}
