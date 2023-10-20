package cn.shh.test.mybatis.service.impl;

import cn.shh.test.mybatis.mapper.UserMapper;
import cn.shh.test.mybatis.pojo.User;
import cn.shh.test.mybatis.service.UserService;

import java.util.HashSet;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getById(int id) {
        return userMapper.getById(id);
    }

    @Override
    public List<User> getALL() {
        return userMapper.getAll();
    }
    @Override
    public List<User> getByLike(String c) {
        return userMapper.getByLike(c);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int deleteByIds(HashSet<Integer> ids) {
        return userMapper.deleteByIds(ids);
    }
}
