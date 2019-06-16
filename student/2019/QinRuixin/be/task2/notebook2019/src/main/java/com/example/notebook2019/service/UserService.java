package com.example.notebook2019.service;

import com.example.notebook2019.entity.UserEntity;
import com.example.notebook2019.form.UserForm;

public interface UserService {
    public UserEntity createUser(UserForm userForm);
}
