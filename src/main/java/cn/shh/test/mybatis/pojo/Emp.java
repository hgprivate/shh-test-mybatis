package cn.shh.test.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {
    private Integer eId;
    private String eName;
    private Integer eAge;
    private String eGender;
    private Dept dept;
}
