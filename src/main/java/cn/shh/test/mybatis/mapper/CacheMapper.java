package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CacheMapper {
    public void insert(Emp emp);
    void insertBatch(@Param("emps") List<Emp> emps);
    public Emp getEmp(Emp emp);
    public List<Emp> getAllEmp();
    public void updateById(Emp emp);
    public int deleteById(@Param("eId") int eId);
    public int deleteByIds(@Param("eIds") String eIds);
    List<Emp> getByLike(@Param("mohu") String mohu);
}
