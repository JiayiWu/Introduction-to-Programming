package cn.edu.nju.notebook.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "todo")
public class TodoEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column
    @NotNull
    private String title;

    @Column
    private String content;

    @Column(name = "createtime")
    @NotNull
    private int createTime;

    @Column(name = "noticeTime")
    @NotNull
    private int noticeTime;

    @Column
    @NotNull
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(int noticeTime) {
        this.noticeTime = noticeTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
