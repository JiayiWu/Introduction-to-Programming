package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
  @Autowired
  public UserMapper userMapper;

  @Test
  public void insert() {
    UserEntity userEntity = new UserEntity();
    userEntity.setName("superfreeeee");
    userEntity.setEmail("123");
    userEntity.setPassword("456");
    int rows = userMapper.insert(userEntity);
    System.err.println("rows = " + rows);
  }

  @Test
  public void selectByPrimaryKey() {
    int id = 13;
    UserEntity userEntity = userMapper.selectByPrimaryKey(id);
    System.err.println(userEntity);
  }
}
