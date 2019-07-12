package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.form.UserForm;
import cn.edu.nju.notebook.entity.UserEntity;

/**
 * Created by Jiayiwu on 19/5/2.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
public interface UserService {

    public UserEntity createUser(UserForm userForm);

    public void modifyPassword(int id,String oldPassword, String newPassword);

    public UserEntity getUser(int id);
}
