package cn.edu.nju.notebook;

import cn.edu.nju.notebook.dao.FolderMapper;
import cn.edu.nju.notebook.dao.TodoMapper;
import cn.edu.nju.notebook.dao.UserMapper;
import cn.edu.nju.notebook.entity.FolderEntity;
import cn.edu.nju.notebook.entity.TodoEntity;
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

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NotebookApplicationTests {
	private Logger logger;

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FolderMapper folderMapper;
	@Autowired
	private TodoMapper todoMapper;


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
	public void UserEntityMapperInsertTest() {
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

	}

	@Test
	@Transactional
	public void UserEntityMapperSelectByPrimaryKeyTest() {
		logger = LoggerFactory.getLogger(getClass());

		UserEntity userEntity = new UserEntity();
		userEntity.setName("test");
		userEntity.setEmail("test@163.com");
		userEntity.setLogoUrl("AAA");
		userEntity.setPassword("AAA");
		userMapper.insert(userEntity);
		UserEntity user1 = userMapper.selectByEmail("test@163.com");

		UserEntity user2 = userMapper.selectByPrimaryKey(user1.getId());
		Assert.assertEquals(user1.getName(),user2.getName());
		logger.info(user1.toString());
	}

	@Test
	@Transactional
	public void FolderEntityMapperTest1(){
		logger = LoggerFactory.getLogger(getClass());

		FolderEntity folderEntity = new FolderEntity();
		folderEntity.setUserId(2);
		folderEntity.setName("testingFolder1");
		folderMapper.insert(folderEntity);
		logger.info(folderEntity.toString());

		Assert.assertEquals(folderEntity.getId(),
				folderMapper.selectByUserIdAndName(2,"testingFolder1").getId());

		folderEntity = new FolderEntity();
		folderEntity.setUserId(2);
		folderEntity.setName("testingFolder2");
		folderMapper.insert(folderEntity);
		logger.info(folderEntity.toString());

		List<FolderEntity> folderEntities = folderMapper.selectByUserId(2);

		folderMapper.selectByUserId(2).forEach((n)->Assert.assertEquals
				(2,Long.parseLong(n.getUserId().toString())));
		logger.info(folderEntities.get(0).toString());
		logger.info(folderEntities.get(1).toString());

		Assert.assertEquals(folderEntity.getId(),
				folderMapper.selectByUserIdAndName(2,"testingFolder2").getId());

	}

	@Test
	@Transactional
	public void TodoEntityMapperTest1(){
		logger = LoggerFactory.getLogger(getClass());

		TodoEntity todoEntity = new TodoEntity();
		todoEntity.setUserId(12);
		todoEntity.setFolderId(2);
		todoEntity.setTitle("test");
		todoEntity.setContent("hello?");
		todoEntity.setCreateTime(System.currentTimeMillis());
		todoEntity.setNoticeTime(System.currentTimeMillis());

		todoMapper.insert(todoEntity);
		logger.info(todoEntity.toString());

		todoEntity.setContent("Hello");
		todoMapper.update(todoEntity);
		logger.info(todoEntity.toString());
		String temp = todoMapper.selectByPrimaryKey(todoEntity.getId()).getContent();
		Assert.assertEquals("Hello",temp);

	}


	@Test
	@Transactional
	public void FolderEntityMapperTest2(){
		logger = LoggerFactory.getLogger(getClass());

		FolderEntity folderEntity = new FolderEntity();
		folderEntity.setUserId(2);
		folderEntity.setName("testingFolder2");
		folderMapper.insert(folderEntity);
		logger.info(folderEntity.toString());
		int id = folderEntity.getId();
		folderMapper.updateNameByPrimaryKey(id,"changedFolder2");

		Assert.assertEquals("changedFolder2",
				folderMapper.selectByPrimaryKey(id).getName());
	}
}