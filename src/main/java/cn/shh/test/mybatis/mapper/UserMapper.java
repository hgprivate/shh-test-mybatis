package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

public interface UserMapper {
    int insert(User user);
    User getById(@Param("id") int id);
    List<User> getAll();
    List<User> getByLike(@Param("mohu") String mohu);
    int updateById(User user);
    int deleteById(@Param("id") int id);
    int deleteByIds(@Param("ids") HashSet<Integer> ids);
}