package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.DynamicSQLMapper;
import cn.shh.test.mybatis.pojo.Dept;
import cn.shh.test.mybatis.pojo.Emp;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MyBatisDynamicSQLTest {

    @Test
    public void testInsertBatch(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
            Emp emp = new Emp(null, "test01", 30, "男", new Dept(2, null, null));
            Emp emp2 = new Emp(null, "test02", 30, "女", new Dept(2, null, null));
            List<Emp> emps = Arrays.asList(emp, emp2);
            dynamicSQLMapper.insertBatch(emps);
            System.out.println("插入成功");
        }
    }

    @Test
    public void testGetByCondition(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DynamicSQLMapper dynamicSQLMapper = sqlSession.getMapper(DynamicSQLMapper.class);
            //Emp emp = dynamicSQLMapper.getEmp(new Emp(null, "张三", null, null, new Dept(1, null, null)));
            //Emp emp = dynamicSQLMapper.getEmp(new Emp(null, "张三", null, null, null));
            //Emp emp = dynamicSQLMapper.getEmpByChoose(new Emp(null, "张三", null, null, new Dept(1, null, null)));
            Emp emp = dynamicSQLMapper.getEmpByChoose(new Emp(null, "张三", null, null, null));
            System.out.println(emp);
        }
    }
}