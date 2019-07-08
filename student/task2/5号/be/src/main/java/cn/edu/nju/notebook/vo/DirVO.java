package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.DirEntity;
import lombok.Data;

@Data
public class DirVO {

    private int id;

    private String title;

    public DirVO(DirEntity dirEntity) {
        if (dirEntity != null) {
            this.id = dirEntity.getId();
            this.title = dirEntity.getTitle();
        }
    }
}
