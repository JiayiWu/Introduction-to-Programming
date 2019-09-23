package cn.edu.nju.notebook.form;

import lombok.Data;

@Data
public class FolderForm {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
