package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.StudyMybatisMapper;
import cn.shh.test.mybatis.mapper.UserMapper;
import cn.shh.test.mybatis.pojo.User;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * mybatis基础增删改查
 */
public class StudyMyBatisTest {
    @Test
    public void testParam(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            StudyMybatisMapper mybatisMapper = sqlSession.getMapper(StudyMybatisMapper.class);
            User user = mybatisMapper.checkLogin("张三", "123321");
            System.out.println(user);
        }
    }

    @Test
    public void testParam2(){
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            StudyMybatisMapper mybatisMapper = sqlSession.getMapper(StudyMybatisMapper.class);

            Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("username", "张三");
            hashMap.put("password", "123321");
            User user = mybatisMapper.checkLogin2(hashMap);
            System.out.println(user);
        }
    }
}