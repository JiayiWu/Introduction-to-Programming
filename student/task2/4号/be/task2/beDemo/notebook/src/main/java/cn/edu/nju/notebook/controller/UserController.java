package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.form.PasswordForm;
import cn.edu.nju.notebook.form.UserForm;
import cn.edu.nju.notebook.service.UserService;
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
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserService userService;
    @ApiOperation(value = "用户注册", response = UserVO.class,notes = "返回SimpleResponse对象，如果成功注册，则SimpleResponse对象Data为UserVO")
    @PostMapping("account")
    public SimpleResponse register(HttpSession session, @RequestBody UserForm userForm){
        UserEntity userEntity = null;
          try {
            userEntity = userService.createUser(userForm);
        } catch (ServerException serverException) {
            return SimpleResponse.error(serverException);
        } catch (Exception e) {
            e.printStackTrace();
            return SimpleResponse.error("Create user error");
        }
        session.setAttribute("user",userEntity);
        return SimpleResponse.ok(new UserVO(userEntity));
    }

    @ApiOperation(value = "修改密码", response = SimpleResponse.class)
    @PostMapping("password")
    public SimpleResponse modifyPassword(HttpSession session, @RequestBody PasswordForm passwordForm){

        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        UserEntity userEntity = (UserEntity) object;
        try {
            userService.modifyPassword(userEntity.getId(),passwordForm.getOldPassword(),passwordForm.getNewPassword());
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Modify the password error");
        }

        return SimpleResponse.ok("Success");
    }
}
