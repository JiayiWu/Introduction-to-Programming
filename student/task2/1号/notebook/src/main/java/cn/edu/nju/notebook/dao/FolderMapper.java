package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.FolderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FolderMapper {

    int insert(FolderEntity folder);

    int deleteByPrimaryKey(Integer id);

    FolderEntity selectByUserIdAndName(Integer userId,String name);

    List<FolderEntity> selectByUserId(Integer userId);

    int updateNameByPrimaryKey(Integer id,String newName);

    FolderEntity selectByPrimaryKey(Integer id);



}
