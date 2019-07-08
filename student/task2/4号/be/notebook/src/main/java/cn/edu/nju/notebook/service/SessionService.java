package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.UserEntity;

public interface SessionService {

    public UserEntity login(String email,String password);
}
