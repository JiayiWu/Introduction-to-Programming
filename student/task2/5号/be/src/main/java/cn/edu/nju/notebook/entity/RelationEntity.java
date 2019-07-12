package cn.edu.nju.notebook.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "relation")
public class RelationEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private int uid;

    @Column
    private int did;

    @Column
    private int tid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
