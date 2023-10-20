package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

public interface UserMapper {
    public void insert(User user);
    public User getById(@Param("id") int id);
    public List<User> getAll();
    List<User> getByLike(@Param("mohu") String mohu);
    public void updateById(User user);
    public int deleteById(@Param("id") int id);
    public int deleteByIds(@Param("ids") HashSet<Integer> ids);
}
