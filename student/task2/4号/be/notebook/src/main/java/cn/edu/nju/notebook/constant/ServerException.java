package cn.edu.nju.notebook.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerException extends RuntimeException{

    private int code;
    private String msg;

    public String getMessage(){
        return this.msg;
    }
}
