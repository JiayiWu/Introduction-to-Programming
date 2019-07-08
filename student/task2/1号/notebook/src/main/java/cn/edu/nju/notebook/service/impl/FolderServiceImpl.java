package cn.edu.nju.notebook.service.impl;

import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.dao.FolderMapper;
import cn.edu.nju.notebook.entity.FolderEntity;
import cn.edu.nju.notebook.entity.TodoEntity;
import cn.edu.nju.notebook.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    FolderMapper folderMapper;

    @Override
    public FolderEntity saveFolder(Integer userId, String name) {
        FolderEntity targetFolder = folderMapper.selectByUserIdAndName(userId,name);
        if(targetFolder!=null){
            throw new ServerException(ResponseCode.Error,"收藏夹已存在");
        }

        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setUserId(userId);
        folderEntity.setName(name);

        folderMapper.insert(folderEntity);

        return folderEntity;
    }

    @Override
    public void delFolder(Integer userId, String name) {
        FolderEntity targetFolder = folderMapper.selectByUserIdAndName(userId,name);
        if(targetFolder==null){
            throw new ServerException(ResponseCode.Error,"收藏夹不存在");
        }
        folderMapper.deleteByPrimaryKey(targetFolder.getId());
    }

    @Override
    public List<FolderEntity> getFolders(Integer userId) {
        List<FolderEntity> folders = folderMapper.selectByUserId(userId);
        return folders;
    }

    @Override
    public FolderEntity updateFolder(Integer userId, Integer id, String newName) {
        FolderEntity targetFolder = folderMapper.selectByUserIdAndName(userId,newName);
        if(targetFolder!=null){
            throw new ServerException(ResponseCode.Error,"收藏夹已存在");
        }
        folderMapper.updateNameByPrimaryKey(id,newName);

        FolderEntity folderEntity = new FolderEntity();
        folderEntity.setId(id);
        folderEntity.setUserId(userId);
        folderEntity.setName(newName);
        return folderEntity;
    }


}
