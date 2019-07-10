package cn.edu.nju.notebook.service;

import cn.edu.nju.notebook.entity.DirEntity;
import cn.edu.nju.notebook.form.DirForm;
import cn.edu.nju.notebook.vo.DirTodoVO;
import cn.edu.nju.notebook.vo.DirVO;

import java.util.List;

public interface DirService {

    public List<DirVO> getDirList(int uid) throws Exception;

    public DirEntity addDir(int uid, DirForm dirForm) throws Exception;

    public void removeDir(int uid, int did) throws Exception;

    public List<DirTodoVO> checkDir(int uid, int did) throws Exception;

    public void addToDir(int uid, int did, int tid) throws Exception;

    public void removeFromDir(int uid, int did, int tid) throws Exception;

}
