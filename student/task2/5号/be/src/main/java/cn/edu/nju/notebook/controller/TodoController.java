package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.form.TodoForm;
import cn.edu.nju.notebook.service.TodoService;
import cn.edu.nju.notebook.vo.TodoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/todo/")
public class TodoController {
    @Autowired
    TodoService todoService;

    @ApiOperation(value = "获取待办事项清单", response = TodoVO.class)
    @GetMapping("list")
    public SimpleResponse getTodoList(HttpSession httpSession) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            List<TodoVO> todoVOList;
            todoVOList = todoService.getTodoList(userEntity.getId());
            return SimpleResponse.ok(todoVOList);
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "添加待办事项", response = TodoVO.class)
    @PostMapping("add")
    public SimpleResponse addTodo(HttpSession httpSession, @RequestBody TodoForm todoForm) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            TodoEntity todoEntity = todoService.addTodo(userEntity.getId(), todoForm);
            return SimpleResponse.ok(todoEntity);
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "查看待办事项", response = TodoVO.class)
    @PostMapping("check/{tid}")
    public SimpleResponse checkTodo(HttpSession httpSession, @PathVariable int tid) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            TodoEntity todoEntity = todoService.checkTodo(userEntity.getId(), tid);
            return SimpleResponse.ok(todoEntity);
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "修改待办事项", response = TodoVO.class)
    @PostMapping("edit/{tid}")
    public SimpleResponse editTodo(HttpSession httpSession, @PathVariable int tid, @RequestBody TodoForm todoForm) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            TodoEntity todoEntity = todoService.editTodo(userEntity.getId(), tid, todoForm);
            return SimpleResponse.ok(todoEntity);
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }

    @ApiOperation(value = "删除待办事项", response = SimpleResponse.class)
    @PostMapping("remove/{tid}")
    public SimpleResponse removeTodo(HttpSession httpSession, @PathVariable int tid) {
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        if (null == userEntity) {
            return SimpleResponse.error("Please login");
        }
        try {
            todoService.removeTodo(userEntity.getId(), tid);
            return SimpleResponse.ok("Success");
        }
        catch (Exception e) {
            return SimpleResponse.error(e.getMessage());
        }
    }
}
