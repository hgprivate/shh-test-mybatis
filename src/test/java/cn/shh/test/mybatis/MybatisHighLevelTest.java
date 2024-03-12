package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.DeptMapper;
import cn.shh.test.mybatis.mapper.EmpMapper;
import cn.shh.test.mybatis.pojo.Dept;
import cn.shh.test.mybatis.pojo.Emp;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 一对多、多对一、模糊匹配
 */
public class MybatisHighLevelTest {
    /**
     * 模糊匹配
     * - where uname like "%"#{c}"%"   （推荐）
     * - where uname like '%${c}%'
     * - where uname like concat('%', #{c}, '%');
     */
    @Test
    public void testFuzzyMatching() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> empList = empMapper.getByLike("张");
            empList.forEach(e -> System.out.println(e.getEName()));
        }
    }

    /**
     * 多对一/ 一对一、延迟加载
     */
    @Test
    public void testGetEmpById() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = empMapper.getEmpByIdStep(1);
            System.out.println(emp.getEName());
            System.out.println("================");
            System.out.println(emp.getDept());
        }
    }

    @Test
    public void testGetAllEmp() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> empList = empMapper.getAllEmp();
            empList.forEach(System.out::println);
        }
    }

    /**
     * 一对多、延迟加载
     */
    @Test
    public void testGetDeptById() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = deptMapper.getDeptByIdStep(1);
            System.out.println(dept.getDName());
            System.out.println("=========================");
            System.out.println(dept.getEmps());
        }
    }
    @Test
    public void testGetAllDept() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            List<Dept> deptList = deptMapper.getAllDept();
            deptList.forEach(System.out::println);
        }
    }
}