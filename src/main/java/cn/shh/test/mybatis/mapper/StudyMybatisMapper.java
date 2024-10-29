package cn.shh.test.mybatis.mapper;

import cn.shh.test.mybatis.pojo.User;

import java.util.Map;

/**
 * mapper接口
 * <p>
 * 参数获取：
 *   - 参数获取方式：#{} 和 ${}
 *     - #{}：占位符赋值
 *     - ${}：字符串拼接，需使用单引号包括。
 *   - 参数名字
 *     - 默认参数名字为arg0、arg1、...，或param1、param2、....。
 *     - 使用map封装参数后，参数名字以map中的key为准。
 * </p>
 */
public interface StudyMybatisMapper {
    User checkLogin(String username, String password);
    User checkLogin2(Map<String, Object> map);
}