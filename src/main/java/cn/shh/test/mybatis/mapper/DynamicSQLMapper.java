package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DynamicSQLMapper {
    int insertBatch(@Param("emps") List<Emp> emps);
    Emp getEmp(Emp emp);
    Emp getEmpByChoose(Emp emp);
    @Select({"<script>" +
            "  select e.e_id, e.e_name, e.e_age, e.e_gender, d.d_id, d.d_name\n" +
            "  from tbl_emp e\n" +
            "  left join tbl_dept d on e.d_id = d.d_id\n" +
            "  <where>\n" +
            "      <choose>\n" +
            "          <when test=\"eId != null and eId !=''\">e.e_id = #{eId}</when>\n" +
            "          <when test=\"eName != null and eName !=''\">and e.e_name = #{eName}</when>\n" +
            "          <when test=\"eAge != null and eAge !=''\">and e.e_age = #{eAge}</when>\n" +
            "          <when test=\"eGender != null and eGender !=''\">and e.e_gender = #{eGender}</when>\n" +
            "          <when test=\"dept.dId != null and dept.dId !=''\">and e.d_id = #{dept.dId}</when>\n" +
            "          <otherwise>\n" +
            "              and e.e_name is not null\n" +
            "          </otherwise>\n" +
            "      </choose>\n" +
            "  </where>" +
            "</script>"})
    Emp getEmpByChoose2(Emp emp);
    List<Emp> getByLike(@Param("mohu") String mohu);
    int updateById(Emp emp);
    int updateById2(Emp emp);
    int deleteByIds(@Param("eIds") String eIds);
}