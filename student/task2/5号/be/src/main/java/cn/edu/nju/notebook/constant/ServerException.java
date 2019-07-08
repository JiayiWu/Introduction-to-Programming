package cn.edu.nju.notebook.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2019/1/14
 */
@Data
@NoArgsConstructor
public class ServerException extends RuntimeException{

    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMessage(){
        return this.msg;
    }

}
