package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.FolderEntity;
import cn.edu.nju.notebook.entity.TodoEntity;

import java.util.List;

public interface FolderService {
    public FolderEntity saveFolder(Integer userId,String name);
    public void delFolder(Integer userId,String name);
    public List<FolderEntity> getFolders(Integer userId);

    public FolderEntity updateFolder(Integer userId,Integer id,String newName);

}
