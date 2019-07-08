package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.form.UserForm;
import cn.edu.nju.notebook.entity.UserEntity;

public interface UserService {

    public UserEntity createUser(UserForm userForm);

    public void modifyPassword(int id,String oldPassword, String newPassword);

    public UserEntity getUser(int id);
}
