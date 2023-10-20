package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

public interface EmpMapper {
    public void insert(Emp emp);
    public Emp getEmpById(@Param("eId") int eId);
    public List<Emp> getAllEmp();
    public void updateById(Emp emp);
    public int deleteById(@Param("eId") int eId);
    public int deleteByIds(@Param("eIds") String eIds);
    public int deleteByIds2(@Param("eIds") HashSet<Integer> eIds);
    List<Emp> getByLike(@Param("mohu") String mohu);
}
