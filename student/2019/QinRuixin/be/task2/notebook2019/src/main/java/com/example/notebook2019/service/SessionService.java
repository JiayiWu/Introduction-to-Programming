package com.example.notebook2019.service;

import com.example.notebook2019.entity.UserEntity;

public interface SessionService {

    public UserEntity login(String email,String password);
}
