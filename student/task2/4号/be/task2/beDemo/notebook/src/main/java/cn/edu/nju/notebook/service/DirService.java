package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.entity.TodoListEntity;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.vo.UserVO;

import java.util.List;

public interface DirService {
    public void create(DirEntity dirEntity);
    public void remove(int todo,int thing);
    public void destroy(int id);
    public void add(int todo,int thing);
}
