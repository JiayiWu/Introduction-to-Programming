package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.DirEntity;

public interface DirService {
    public void create(DirEntity dirEntity);
    public void remove(int todo,int thing);
    public void destroy(int id);
    public void add(int todo,int thing);
}
