package cn.edu.nju.notebook.form;

import lombok.Data;

@Data
public class TodoForm {
    private String title;
    private Long createTime;
    private Long noticeTime;
    private String content;
}
