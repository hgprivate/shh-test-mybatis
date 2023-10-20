package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.UserMapper;
import cn.shh.test.mybatis.pojo.User;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import java.util.HashSet;
import java.util.List;

/**
 * 增删改查（基础）
 */
public class MyBatisBaseTest {

    @Test
    public void testInsert(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUname("李四3");
            user.setPassword("123321");
            user.setAge(19);
            user.setGender("男");
            user.setEmail("lisi@qq.com");
            userMapper.insert(user);
            System.out.println("插入成功。");
        }
    }

    @Test
    public void testGetById(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getById(1);
            System.out.println("user = " + user);
        }
    }

    @Test
    public void testGetAll(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getAll();
            userList.forEach(System.out::println);
        }
    }

    @Test
    public void testUpdate(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setId(5);
            user.setUname("王五");
            user.setPassword("123321");
            user.setAge(19);
            user.setGender("男");
            user.setEmail("wangwu@qq.com");
            userMapper.updateById(user);
            System.out.println("修改成功");
        }
    }

    @Test
    public void testDelete(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            HashSet<Integer> ids = new HashSet<>();
            ids.add(3);
            ids.add(4);
            ids.add(5);
            userMapper.deleteByIds(ids);
            System.out.println("删除成功");
        }
    }
}