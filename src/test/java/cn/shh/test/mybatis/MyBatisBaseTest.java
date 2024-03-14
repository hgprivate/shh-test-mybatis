package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.UserMapper;
import cn.shh.test.mybatis.pojo.User;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

/**
 * mybatis基础增删改查
 */
public class MyBatisBaseTest {
    /**
     * 插入一条数据
     */
    @Test
    public void testInsert() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUname("李四4");
            user.setPassword("123321");
            user.setAge(24);
            user.setGender("男");
            user.setEmail("lisi@qq.com");
            int result = userMapper.insert(user);
            System.out.println(result > 0 ? "success " + result : "error " + result);
            System.out.println("user = " + user);
        }
    }

    /**
     * 根据用户ID获取其用户数据
     */
    @Test
    public void testGetById() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            // userMapper其实是一个代理对象（MapperProxy）
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getById(1);
            System.out.println("user = " + user);
        }
    }

    /**
     * 获取表中所有数据
     */
    @Test
    public void testGetAll() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getAll();
            userList.forEach(System.out::println);
        }
    }

    /**
     * 修改指定用户ID的数据
     */
    @Test
    public void testUpdate() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(11);
            user.setUname("王五");
            user.setPassword("123321");
            user.setAge(19);
            user.setGender("男");
            user.setEmail("wangwu@qq.com");
            int result = userMapper.updateById(user);
            System.out.println(result > 0 ? "success" : "error");
        }
    }

    /**
     * 删除指定用户ID的数据
     */
    @Test
    public void testDelete() {
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            HashSet<Integer> ids = new HashSet<>();
            ids.add(6);
            ids.add(7);
            ids.add(11);
            int result = userMapper.deleteByIds(ids);
            System.out.println(result > 0 ? "success " + result : "error " + result);
        }
    }
}