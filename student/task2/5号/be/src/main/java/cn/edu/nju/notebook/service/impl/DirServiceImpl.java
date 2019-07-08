package cn.edu.nju.notebook.service.impl;
import cn.edu.nju.notebook.dao.DirMapper;
import cn.edu.nju.notebook.form.DirForm;
import cn.edu.nju.notebook.vo.DirTodoVO;
import cn.edu.nju.notebook.vo.DirVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.nju.notebook.service.DirService;

import java.util.List;

@Service
public class DirServiceImpl implements DirService {

    @Autowired
    DirMapper dirMapper;


    @Override
    public List<DirVO> getDirList(int uid) throws Exception {
        return null;
    }

    @Override
    public DirVO addDir(int uid, DirForm dirForm) throws Exception {
        return null;
    }

    @Override
    public void removeDir(int uid, int did) throws Exception {

    }

    @Override
    public List<DirTodoVO> checkDir(int uid, int did) throws Exception {
        return null;
    }

    @Override
    public void addToDir(int uid, int did, int tid) throws Exception {

    }

    @Override
    public void removeFromDir(int uid, int did, int tid) throws Exception {

    }
}
