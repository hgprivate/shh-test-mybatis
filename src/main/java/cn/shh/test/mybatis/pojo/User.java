package cn.shh.test.mybatis.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 实体类User
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String uname;
    private String password;
    private Integer age;
    private String gender;
    private String email;

}
