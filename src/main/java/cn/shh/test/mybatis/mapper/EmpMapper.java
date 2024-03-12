package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface EmpMapper {
    int insert(Emp emp);
    int insertBatch(@Param("empList") List<Emp> empList);

    Emp getEmpById(@Param("eId") int eId);
    Emp getEmpByIdStep(@Param("eId") int eId);
    List<Emp> getEmpsByDeptId(@Param("dId") int dId);
    List<Emp> getAllEmp();
    List<Emp> getByLike(@Param("mohu") String mohu);

    int updateById(Emp emp);

    int deleteById(@Param("eId") int eId);
    int deleteByIds(@Param("eIds") String eIds);
    int deleteByIds2(@Param("eIds") HashSet<Integer> eIds);
}