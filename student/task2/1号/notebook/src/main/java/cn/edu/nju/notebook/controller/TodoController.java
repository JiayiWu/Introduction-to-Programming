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
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @ApiOperation(value = "添加待办事项", response = TodoVO.class, notes = "返回SimpleResponse对象，如果新建成功，则SimpleResponse对象Data为TodoVO")
    @PostMapping("add/{folderId}")
    public SimpleResponse addTodo(HttpSession session,@PathVariable("folderId") Integer folderId, @RequestBody TodoForm todoForm){
        Object userEntity = session.getAttribute("user");
        if(userEntity==null){
            return SimpleResponse.error("Not login");
        }
        TodoEntity todoEntity = null;
        try{
            todoEntity = todoService.addTodo(((UserEntity)userEntity).getId(),folderId,todoForm);
        }catch (Exception ex){
            return SimpleResponse.exception(ex);
        }
        return SimpleResponse.ok(new TodoVO(todoEntity));
    }

    @ApiOperation(value = "查看待办事项",response = TodoVO.class, notes = "返回SimpleResponse对象，如果查看成功，则SimpleResponse对象Data为TodoVO")
    @GetMapping("/check/{todoId}")
    public SimpleResponse checkTodo(HttpSession session,@PathVariable("todoId") Integer todoId){
        Object userEntity = session.getAttribute("user");
        if(userEntity==null){
            return SimpleResponse.error("Not login");
        }
        TodoEntity todoEntity = null;
        try{
            todoEntity = todoService.checkTodo(todoId);
        }catch (Exception ex){
            return SimpleResponse.exception(ex);
        }
        return SimpleResponse.ok(new TodoVO(todoEntity));

    }

    @ApiOperation(value = "删除待办事项",response = TodoVO.class, notes = "返回SimpleResponse对象")
    @GetMapping("/del/{todoId}")
    public SimpleResponse delTodo(HttpSession session,@PathVariable("todoId") Integer todoId){
        Object userEntity = session.getAttribute("user");
        if(userEntity==null){
            return SimpleResponse.error("Not login");
        }
        try{
            todoService.delTodo(todoId);
        }catch (Exception ex){
            return SimpleResponse.exception(ex);
        }
        return SimpleResponse.ok("Succeed");
    }


    @ApiOperation(value = "修改待办事项",response = TodoVO.class, notes = "返回SimpleResponse对象，如果修改成功，则SimpleResponse对象Data为新的TodoVO")
    @PostMapping("/update/{todoId}")
    public SimpleResponse updateTodo(HttpSession session,@PathVariable("todoId") Integer todoId,@RequestBody TodoForm todoForm){
        Object userEntity = session.getAttribute("user");
        if(userEntity==null){
            return SimpleResponse.error("Not login");
        }
        TodoEntity todoEntity = null;
        try{
            todoEntity = todoService.updateTodo(todoId,todoForm);
        }catch (Exception ex){
            return SimpleResponse.exception(ex);
        }
        return SimpleResponse.ok(new TodoVO(todoEntity));

    }

    @ApiOperation(value = "获取文件夹下所有待办事项", response = List.class, notes = "返回SimpleResponse对象，如果当前用户已经登录，则SimpleResponse对象Data为包含TodoEntity的数组")
    @GetMapping("{folderId}")
    public SimpleResponse showTodo(HttpSession session, @PathVariable("folderId") Integer folderId) {
        if (folderId <= 0) {
            return SimpleResponse.error("参数错误");
        }
        Object userInfo = session.getAttribute("user");

        if (userInfo == null) {
            return SimpleResponse.error("Not login");
        }

        List<TodoEntity> todos = null;

        try{
            todos = todoService.getTodos(folderId);
        }catch (Exception ex){
            return SimpleResponse.exception(ex);
        }

        return SimpleResponse.ok(todos);

    }

}
