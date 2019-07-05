package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.dao.UserMapper;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.SessionService;
import cn.edu.nju.notebook.util.MD5Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * Created by Jiayiwu on 19/5/2.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    UserMapper userMapper;

    @Override
    public UserEntity login(String email, String password) {
        UserEntity userEntity = userMapper.selectByEmail(email);
//        System.out.println(userEntity);
        try {
            if (!userEntity.getPassword().equals(MD5Encryption.encrypt(password))){
                throw new ServerException(ResponseCode.Error, "Password error");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return userEntity;
    }
}
