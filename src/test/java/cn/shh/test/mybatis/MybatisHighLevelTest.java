package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.DeptMapper;
import cn.shh.test.mybatis.mapper.EmpMapper;
import cn.shh.test.mybatis.pojo.Dept;
import cn.shh.test.mybatis.pojo.Emp;
import cn.shh.test.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 一对多、多对一、模糊匹配
 */
public class MybatisHighLevelTest {

    /**
     * 模糊匹配
     *      - where uname like "%"#{c}"%"   （推荐）
     *      - where uname like '%${c}%'
     *      - where uname like concat('%', #{c}, '%');
     */
    @Test
    public void testFuzzyMatching(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> empList = empMapper.getByLike("张");
            empList.forEach(e -> System.out.println(e.getEName()));
        }
    }

    /**
     * 多对一、延迟加载
     */
    @Test
    public void testGetEmpById(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            Emp emp = empMapper.getEmpById(1);
            System.out.println(emp.getEName());
        }
    }
    @Test
    public void testGetAllEmp(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            List<Emp> empList = empMapper.getAllEmp();
            empList.forEach(System.out::println);
        }
    }
    @Test
    public void testUpdateById(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            empMapper.updateById(new Emp(1, "张三2", 20, "男", new Dept(2, null, null)));
            System.out.println("修改成功。");
        }
    }
    @Test
    public void testDeleteById(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            int count = empMapper.deleteById(5);
            System.out.println(count>0 ? "删除成功" : "删除失败");
        }
    }
    @Test
    public void testDeleteByIds(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
            int count = empMapper.deleteByIds("5, 6");
            System.out.println(count>0 ? "删除成功" : "删除失败");
        }
    }

    /**
     * 一对多、延迟加载
     */
    @Test
    public void testGetDeptById(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = deptMapper.getDeptById(1);
            System.out.println(dept);
        }
    }
    @Test
    public void testGetAllDept(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            List<Dept> deptList = deptMapper.getAllDept();
            deptList.forEach(System.out::println);
        }
    }

}
