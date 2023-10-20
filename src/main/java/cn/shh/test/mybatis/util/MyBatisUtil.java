package cn.shh.test.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 */
public class MyBatisUtil {
    private static final String RESOURCE = "mybatis-config.xml";

    public static SqlSessionFactory getSqlSessionFactory(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(RESOURCE);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            return sessionFactory;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static SqlSession getSqlSession(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(RESOURCE);
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            return sessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}