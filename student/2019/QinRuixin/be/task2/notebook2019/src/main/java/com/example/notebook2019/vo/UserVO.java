package com.example.notebook2019.vo;

import com.example.notebook2019.entity.UserEntity;
import lombok.Data;

@Data
public class UserVO {
    private int id;
    private String name;
    private String email;
    private String logoUrl;

    public UserVO(UserEntity userEntity){
        if(userEntity!=null){
            this.id = userEntity.getId();
            this.name = userEntity.getName();
            this.email = userEntity.getEmail();
            this.logoUrl = userEntity.getLogoUrl();

        }
    }


}
