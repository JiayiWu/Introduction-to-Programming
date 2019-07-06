package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.FolderEntity;
import lombok.Data;

@Data
public class FolderVO {

    private Integer id;

    private Integer userId;

    private String name;

    /**
     *
     * @param folderEntity
     */
    public FolderVO(FolderEntity folderEntity){
        if(folderEntity!=null){
            this.id = folderEntity.getId();
            this.userId = folderEntity.getUserId();
            this.name = folderEntity.getName();
        }
    }
}
