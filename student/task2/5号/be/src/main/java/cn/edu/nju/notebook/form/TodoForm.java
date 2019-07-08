package cn.edu.nju.notebook.form;

import lombok.Data;

@Data
public class TodoForm {

    private String title;

    private String content;

    private int createTime;

    private int noticeTime;

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
}
