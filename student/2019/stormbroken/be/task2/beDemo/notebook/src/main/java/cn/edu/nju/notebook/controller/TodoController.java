package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/todolist/")
public class TodoController {
    @Autowired
    TodoService todoService;
    UserService userService;
    @PostMapping("add")
    public SimpleResponse add(HttpSession session, TodoListEntity todoListEntity){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
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
            return SimpleResponse.error("Add the TODO failed.");
        }
    }
    @GetMapping("get")
    public SimpleResponse get(HttpSession session){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        UserEntity userEntity = (UserEntity) object;
        try {
            List<TodoListEntity> todoListEntities = todoService.get(userEntity);
            return SimpleResponse.ok(todoListEntities);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed to get the name");
        }
    }
    @PostMapping("edit/{id}")
    public SimpleResponse edit(HttpSession session,@PathVariable("id")int id, TodoListEntity todoListEntity){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        try {
            todoService.edit(todoListEntity);
            UserEntity userEntity = userService.getUser(id);
            return SimpleResponse.ok(userEntity);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed to update the edition.");
        }
    }
    @PostMapping("remove/{id}")
    public SimpleResponse remove(HttpSession session,@PathVariable("id")int id){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        try {
            todoService.remove(id);
            return SimpleResponse.ok(null);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Failed to remove the TODO.");
        }
    }

}
