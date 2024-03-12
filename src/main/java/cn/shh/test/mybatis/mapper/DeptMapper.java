package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

public interface DeptMapper {
    int insert(Dept dept);
    int insertBatch(@Param("deptList") List<Dept> deptList);

    Dept getDeptById(@Param("dId") int dId);
    Dept getDeptByIdStep(@Param("dId") int dId);
    List<Dept> getAllDept();
    List<Dept> getByLike(@Param("mohu") String mohu);

    void updateById(Dept dept);

    int deleteById(@Param("id") int id);
    int deleteByIds(@Param("ids") String ids);
    int deleteByIds2(@Param("ids") HashSet<Integer> ids);
}