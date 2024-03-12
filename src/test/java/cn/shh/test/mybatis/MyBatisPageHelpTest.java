package cn.shh.test.mybatis;

import cn.shh.test.mybatis.mapper.UserMapper;
import cn.shh.test.mybatis.pojo.User;
import cn.shh.test.mybatis.util.MyBatisUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MyBatisPageHelpTest {
    /**
     * 分页测试
     */
    @Test
    public void testGetUserPage(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            PageHelper.startPage(2, 1);
            List<User> userList = userMapper.getAll();
            userList.forEach(System.out::println);
        }
    }

    /**
     * Page 和 PageInfo
     *
     * page: Page{
     *     count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=8, pages=3, reasonable=false, pageSizeZero=false
     *   }
     *   [
     *     User(id=4, uname=赵六, password=null, age=18, gender=男, email=zhaoliu@qq.com),
     *     User(id=5, uname=孙悟空, password=null, age=35, gender=男, email=sunwukong@google.com),
     *     User(id=6, uname=猪八戒, password=null, age=33, gender=男, email=zhubajie@qq.com)
     *   ]
     *
     * pageInfo: PageInfo{
     *   pageNum=2, pageSize=3, size=3, startRow=4, endRow=6, total=8, pages=3,
     *   list=Page{
     *     count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=8, pages=3, reasonable=false, pageSizeZero=false
     *   }
     *   [
     *     User(id=4, uname=赵六, password=null, age=18, gender=男, email=zhaoliu@qq.com),
     *     User(id=5, uname=孙悟空, password=null, age=35, gender=男, email=sunwukong@google.com),
     *     User(id=6, uname=猪八戒, password=null, age=33, gender=男, email=zhubajie@qq.com)
     *   ],
     *   prePage=1, nextPage=3, isFirstPage=false, isLastPage=false, hasPreviousPage=true, hasNextPage=true,
     *   navigatePages=8, navigateFirstPage=1, navigateLastPage=3, navigatepageNums=[1, 2, 3]
     * }
     */
    @Test
    public void testGetUserPage2(){
        try(SqlSession sqlSession = MyBatisUtil.getSqlSession()) {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Page<Object> page = PageHelper.startPage(2, 3);
            List<User> userList = userMapper.getAll();
            PageInfo<User> userPageInfo = new PageInfo<>(userList);
            userList.forEach(System.out::println);
            System.out.println("page: " + page);
            System.out.println("pageInfo: " + userPageInfo);
        }
    }
}