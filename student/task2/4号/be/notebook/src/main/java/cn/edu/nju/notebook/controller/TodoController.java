package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.DataEntity;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/todolist/")
public class TodoController {
    @Autowired
    TodoService todoService;
    UserService userService;
    @PostMapping("add")
    public SimpleResponse add(HttpSession session,@RequestBody TodoEntity todoListEntity){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login.");
        }
        UserEntity userEntity = (UserEntity) object;
        todoListEntity.setUser(userEntity.getName());
        try {
            todoService.add(todoListEntity);
            return SimpleResponse.ok(todoListEntity);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed.");
        }
    }
    @GetMapping("get")
    public SimpleResponse get(HttpSession session){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login.");
        }
        UserEntity userEntity = (UserEntity) object;
        try {
            DataEntity dataEntity = todoService.get(userEntity);
            return SimpleResponse.ok(dataEntity);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed.");
        }
    }
    @PostMapping("edit")
    public SimpleResponse edit(HttpSession session,@RequestBody TodoEntity todoListEntity){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login.");
        }
        try {
            UserEntity userEntity = (UserEntity) object;
            todoListEntity.setUser(userEntity.getName());
            todoService.edit(todoListEntity);
            return SimpleResponse.ok(todoListEntity);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed.");
        }
    }
    @PostMapping("remove/{id}")
    public SimpleResponse remove(HttpSession session,@PathVariable("id")int id){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login.");
        }
        try {
            UserEntity userEntity = (UserEntity) object;
            todoService.remove(userEntity.getName(),id);
            return SimpleResponse.ok(null);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed.");
        }
    }

}
