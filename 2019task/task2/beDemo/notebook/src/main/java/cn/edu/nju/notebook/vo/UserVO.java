package cn.edu.nju.notebook.vo;

import cn.edu.nju.notebook.entity.UserEntity;
import lombok.Data;

/**
 * Created by Jiayiwu on 19/5/2.
 * Mail:wujiayi@lgdreamer.com
 * Change everywhere
 */
@Data
public class UserVO {
    private Integer id;

    private String name;

    private String email;

    private String logoUrl;

    public UserVO(UserEntity userEntity) {
        if (userEntity != null) {
            this.id = userEntity.getId();
            this.email = userEntity.getEmail();
            this.logoUrl = userEntity.getLogoUrl();
            this.name = userEntity.getName();
        }
    }
}
