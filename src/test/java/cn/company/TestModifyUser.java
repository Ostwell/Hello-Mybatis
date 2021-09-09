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
 * description:测试类-修改User
 * author: 
 * create time:  2021/9/2 17:28
 */
public class TestModifyUser {
    @Test
    public void testModify() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);
        String sqlId = "cn.company.dao.UserDao.modifyUser";

        User user = new User();
        user.setUsername("牛魔王");
        user.setAge(25);
        user.setEmail("123@qq.com");
        user.setId(2006);
        int nums = sqlSession.insert(sqlId, user);

        System.out.println("执行modify的结果=" + nums);
        sqlSession.close();
    }

    //使用工具类精简代码
    @Test
    public void testModify02() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "cn.company.dao.UserDao.modifyUser";

        User user = new User();
        user.setId(2003);
        user.setUsername("张无忌");
        user.setAge(10);
        user.setEmail("wwj@qq.com");
        int num = sqlSession.update(sqlId, user);
        sqlSession.commit();//增删改记得提交

        System.out.println("使用工具类根据id修改的执行结果： " + num);
        sqlSession.close();
    }
}
