package cn.shh.test.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept implements Serializable {
    private Integer dId;
    private String dName;
    private List<Emp> emps;
}
