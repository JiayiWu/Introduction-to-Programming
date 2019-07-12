package cn.edu.nju.notebook.dao;

import cn.edu.nju.notebook.entity.RelationEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationMapper {

    @Query(nativeQuery = true, value = "SELECT FROM relation r WHERE r.uid = :uid AND r.did = :did")
    List<RelationEntity> selectByUidAndDid(@Param("uid") int uid, @Param("did") int did);

    @Modifying
    int insert(RelationEntity record);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM relation r WHERE r.uid = :uid AND r.did = :did AND r.tid = :tid")
    int deleteByUidAndDidAndTid(@Param("uid") int uid, @Param("did") int did, @Param("tid") int tid);

}
