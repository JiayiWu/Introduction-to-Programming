package cn.edu.nju.notebook.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "directory")
public class DirEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column
    private int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
