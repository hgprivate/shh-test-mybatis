package cn.shh.test.mybatis.service;

import cn.shh.test.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashSet;
import java.util.List;

public interface UserService {
    public void insert(User user);
    public User getById(int id);
    public List<User> getALL();
    List<User> getByLike(String c);
    public void updateById(User user);
    public int deleteById(@Param("id") int id);
    public int deleteByIds(@Param("ids") HashSet<Integer> ids);
}
