package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.service.SessionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionServiceTest {

  @Autowired
  public SessionService sessionService;

  @Test
  public void login() {
    String email = "email2";
    String password = "123";
    System.out.println(sessionService);
    UserEntity userEntity = sessionService.login(email, password);
    System.err.println(userEntity.getName());
  }

}
