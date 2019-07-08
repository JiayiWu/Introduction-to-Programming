package cn.edu.nju.notebook.form;

import lombok.Data;

@Data
public class DirForm {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
