package cn.company;

import cn.company.entity.User;
import cn.company.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * description: mybatis 测试类-新增数据
 * author:
 * create time:  2021/9/2 16:08
 */
public class TestInsertUser {

    //测试方法，测试功能
    @Test
    public void testInsert01() throws IOException {

        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession(true);
        String sqlId = "cn.company.dao.UserDao.insertUser";
        User user = new User();
        user.setUsername("唐僧");
        user.setEmail("tangseng");
        user.setAge(20);
        int nums = sqlSession.insert(sqlId, user);
        System.out.println("执行insert的结果=" + nums);

        sqlSession.close();
    }


    //使用工具类精简代码
    @Test
    public void testInsert02() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "cn.company.dao.UserDao.insertUser";

        User user = new User();
        user.setUsername("武松");
        user.setAge(10);
        user.setEmail("wusong@qq.com");
        int num = sqlSession.insert(sqlId, user);
        sqlSession.commit();//增删改记得提交

        System.out.println("使用工具类insert的执行结果： " + num);
        sqlSession.close();
    }
}