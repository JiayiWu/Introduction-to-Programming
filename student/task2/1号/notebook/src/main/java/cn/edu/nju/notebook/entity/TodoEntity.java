package cn.edu.nju.notebook.entity;

import lombok.Data;

@Data
public class TodoEntity {
    private Integer id;
    private Integer userId;
    private Integer folderId;
    private String title;
    private long createTime;
    private long noticeTime;
    private String content;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(long noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public void setUserId(int i) {
        userId = i;
    }
}
