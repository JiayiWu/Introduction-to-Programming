package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.UserEntity;
import lombok.Data;

@Data
public class UserVO {
    private int id;
    private String name;
    private String email;
    private String logoUrl;

    public UserVO(UserEntity userEntity) {
        if (userEntity != null) {
            this.id = userEntity.getId();
            this.name = userEntity.getName();
            this.email = userEntity.getEmail();
            this.logoUrl = userEntity.getLogoUrl();
        }
    }
}
