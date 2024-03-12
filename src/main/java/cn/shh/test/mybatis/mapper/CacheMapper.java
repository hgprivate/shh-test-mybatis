package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CacheMapper {
    void insert(Emp emp);
    void insertBatch(@Param("emps") List<Emp> emps);
    Emp getEmp(Emp emp);
    List<Emp> getAllEmp();
    void updateById(Emp emp);
    int deleteById(@Param("eId") int eId);
    int deleteByIds(@Param("eIds") String eIds);
    List<Emp> getByLike(@Param("mohu") String mohu);
}