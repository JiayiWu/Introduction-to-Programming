package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.dao.UserMapper;
import cn.edu.nju.notebook.form.UserForm;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.UserService;
import cn.edu.nju.notebook.util.MD5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public UserEntity createUser(UserForm userForm) {
        UserEntity targetUser = userMapper.selectByEmail(userForm.getEmail());
        if (null != targetUser)
            throw new ServerException(ResponseCode.Error,"Repeat of username");

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userForm.getName());
        userEntity.setEmail(userForm.getEmail());
        userEntity.setLogoUrl(userForm.getLogoUrl());
        try {
            userEntity.setPassword(MD5Encryption.encrypt(userForm.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ServerException(ResponseCode.Error,"Encode error");
        }
        userMapper.insert(userEntity);
        return userEntity;
    }

    @Override
    public void modifyPassword(int id, String oldPassword,String newPassword) {
        UserEntity userEntity = userMapper.selectByPrimaryKey(id);
        try {
            if (!userEntity.getPassword().equals(MD5Encryption.encrypt(oldPassword))){
                throw new ServerException(ResponseCode.Error,"Password error");
            }
            userEntity.setPassword(MD5Encryption.encrypt(newPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserEntity getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
