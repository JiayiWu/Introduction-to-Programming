package cn.edu.nju.notebook.service.impl;
import cn.edu.nju.notebook.constant.ResponseCode;
import cn.edu.nju.notebook.constant.ServerException;
import cn.edu.nju.notebook.dao.DirMapper;
import cn.edu.nju.notebook.dao.RelationMapper;
import cn.edu.nju.notebook.dao.TodoMapper;
import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.entity.RelationEntity;
import cn.edu.nju.notebook.form.DirForm;
import cn.edu.nju.notebook.vo.DirTodoVO;
import cn.edu.nju.notebook.vo.DirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.nju.notebook.service.DirService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DirServiceImpl implements DirService {

    @Autowired
    DirMapper dirMapper;

    @Autowired
    RelationMapper relationMapper;

    @Autowired
    TodoMapper todoMapper;


    @Override
    public List<DirVO> getDirList(int uid) throws Exception {
        try {
            List<DirEntity> dirEntityList = dirMapper.selectByUserId(uid);
            List<DirVO> dirVOList = new ArrayList<>();
            for (int i = 0; i < dirEntityList.size(); ++i) {
                dirVOList.add(new DirVO(dirEntityList.get(i)));
            }
            return dirVOList;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "select error");
        }
    }

    @Override
    public DirEntity addDir(int uid, DirForm dirForm) throws Exception {
        DirEntity dirEntity = new DirEntity();
        dirEntity.setTitle(dirForm.getTitle());
        dirEntity.setUid(uid);
        try {
            dirMapper.insert(dirEntity);
            return dirEntity;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "insert error");
        }
    }

    @Override
    public void removeDir(int uid, int did) throws Exception {
        try {
            dirMapper.deleteByPrimaryKeySelective(did, uid);
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "delete error");
        }
    }

    @Override
    public List<DirTodoVO> checkDir(int uid, int did) throws Exception {
        try {
            List<RelationEntity> relationEntityList = relationMapper.selectByUidAndDid(uid, did);
            List<DirTodoVO> dirTodoVOList = new ArrayList<>();
            for (RelationEntity relationEntity : relationEntityList) {
                dirTodoVOList.add(new DirTodoVO(todoMapper.selectByIdAndUid(relationEntity.getTid(), uid)));
            }
            return dirTodoVOList;
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "select error");
        }
    }

    @Override
    public void addToDir(int uid, int did, int tid) throws Exception {
        try {
            RelationEntity relationEntity = new RelationEntity();
            relationEntity.setUid(uid);
            relationEntity.setDid(did);
            relationEntity.setTid(tid);
            relationMapper.insert(relationEntity);
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "insert error");
        }
    }

    @Override
    public void removeFromDir(int uid, int did, int tid) throws Exception {
        try {
            relationMapper.deleteByUidAndDidAndTid(uid, did, tid);
        }
        catch (Exception e) {
            throw new ServerException(ResponseCode.Error, "delete error");
        }
    }
}
