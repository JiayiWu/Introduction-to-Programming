package cn.edu.nju.notebook.controller;

import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.constant.SimpleResponse;
import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.DirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/dir/")
public class DirController {

    @Autowired
    DirService dirService;

    @PostMapping("create")
    public SimpleResponse create(HttpSession session,@RequestBody DirEntity dirEntity){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        UserEntity userEntity = (UserEntity) object;
        try {
            dirEntity.setUser(userEntity.getName());
            dirService.create(dirEntity);
            return SimpleResponse.ok(dirEntity);
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("Create dir failed.");
        }
    }
    @PostMapping("destroy/{id}")
    public SimpleResponse destroy(HttpSession session, @PathVariable("id") int id){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        try {
            dirService.destroy(id);
            return SimpleResponse.ok("distroy");
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("destroy failed.");
        }
    }
    @PostMapping("remove/{todo}/{thing}")
    public SimpleResponse remove(HttpSession session,
                                 @PathVariable("todo") int todo,
                                 @PathVariable("thing") int thing){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        try {
            dirService.remove(todo,thing);
            return SimpleResponse.ok("remove");
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("remove failed.");
        }

    }
    @PostMapping("add/{todo}/{thing}")
    public SimpleResponse add(HttpSession session,
                              @PathVariable("todo") int todo,
                              @PathVariable("thing") int thing){
        Object object = session.getAttribute("user");
        if (null == object){
            return SimpleResponse.error("Please login");
        }
        try {
            dirService.add(todo,thing);
            return SimpleResponse.ok("add");
        }catch (ServerException serverException){
            return SimpleResponse.error(serverException.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return SimpleResponse.error("add failed.");
        }
    }
}
