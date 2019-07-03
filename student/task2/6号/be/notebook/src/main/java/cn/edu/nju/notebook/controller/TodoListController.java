package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.service.TodoListService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/todo_list/")
public class TodoListController {

  @Autowired
  TodoListService todoListService;

  @ApiOperation(value = "读取数据", response = SimpleResponse.class)
  @GetMapping("read")
  public SimpleResponse read(HttpSession session) {
    List<TodoListEntity> todoListEntities = null;
    try {
      todoListEntities = todoListService.read();
    }catch (Exception ex) {
      ex.printStackTrace();
      return SimpleResponse.error("read todoLists error");
    }
    session.setAttribute("todoLists", todoListEntities);
    return SimpleResponse.ok(todoListEntities);
  }

  @ApiOperation(value = "读取数据", response = SimpleResponse.class)
  @PostMapping("write")
  public SimpleResponse write(HttpSession session, @RequestBody List<TodoListEntity> todoListEntities) {
    try {
      todoListService.write(todoListEntities);
    }catch (Exception ex) {
      ex.printStackTrace();
      return SimpleResponse.error("error");
    }
    return SimpleResponse.ok("sucess");
  }
}
