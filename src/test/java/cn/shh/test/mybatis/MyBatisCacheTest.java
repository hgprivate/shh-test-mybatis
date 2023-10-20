package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.CacheMapper;
import cn.shh.test.mybatis.pojo.Dept;
import cn.shh.test.mybatis.pojo.Emp;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class MyBatisCacheTest {

    /**
     * 一级缓存访问测试
     *
     * 开启条件：默认开启。
     */
    @Test
    public void testGetEmpByOneLevelCache(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = new Emp(null, "test01", 30, "女", new Dept(2, null, null));
            Emp result = cacheMapper.getEmp(emp);
            System.out.println(result);
            System.out.println("===============================================");
            Emp result2 = cacheMapper.getEmp(emp);
            System.out.println(result2);
        }
    }

    /**
     * 二级缓存访问测试
     *
     * 开启条件：
     *      - mybatis配置文件中添加配置项：<setting name="cacheEnabled" value="true"/>
     *      - mapper映射文件中添加配置项： <cache/>
     *      - 涉及到的实体类需要实现序列化接口。
     *      - SqlSession关闭后才会有效。
     */
    @Test
    public void testGetEmpByTwoLevelCache(){
        SqlSessionFactory sessionFactory = MyBatisUtil.getSqlSessionFactory();
        try(SqlSession sqlSession = sessionFactory.openSession(true)) {
            CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = new Emp(null, "test01", 30, "女", new Dept(2, null, null));
            Emp result = cacheMapper.getEmp(emp);
            System.out.println(result);
        }
        System.out.println("===============================================");
        try(SqlSession sqlSession = sessionFactory.openSession(true)) {
            CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
            Emp emp = new Emp(null, "test01", 30, "女", new Dept(2, null, null));
            Emp result = cacheMapper.getEmp(emp);
            System.out.println(result);
        }
    }
}