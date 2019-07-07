package cn.edu.nju.notebook;

import cn.edu.nju.notebook.dao.UserMapper;
import cn.edu.nju.notebook.entity.UserEntity;
import cn.edu.nju.notebook.form.UserForm;
import cn.edu.nju.notebook.service.impl.FolderServiceImpl;
import cn.edu.nju.notebook.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotebookApplicationTests {

	private Logger logger;
	@Autowired
	private UserMapper userMapper;

	/**
	 * 添加Mybatis单元测试
	 * 官方文档
	 * In its default configuration, the Spring Framework’s transaction infrastructure code
	 * only marks a transaction for rollback in the case of runtime, unchecked exceptions;
	 * that is, when the thrown exception is an instance or subclass of RuntimeException.
	 * ( Errors will also - by default - result in a rollback）
	 *
	 * 加注解@Transactional 事务自动回滚
	 */
	@Test
	@Transactional
	//@Rollback 默认为true，可以不写
	public void setUserMapper(){
		logger = LoggerFactory.getLogger(getClass());

		UserEntity userEntity = new UserEntity();
		userEntity.setName("test");
		userEntity.setEmail("test@163.com");
		userEntity.setLogoUrl("AAA");
		userEntity.setPassword("AAA");
		userMapper.insert(userEntity);

		UserEntity user1 = userMapper.selectByEmail("test@163.com");
		Assert.assertEquals("test",user1.getName());
		logger.info(user1.toString());

		UserEntity user2 = userMapper.selectByPrimaryKey(user1.getId());
		Assert.assertEquals(user1.getName(),user2.getName());
		logger.info(user1.toString());
	}

}
