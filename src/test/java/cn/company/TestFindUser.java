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
import java.util.List;

/**
 * description: 测试类-查找User
 * author: 
 * create time:  2021/9/2 17:27
 */
public class TestFindUser {
    @Test
    public void testFindAllUsers01() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();

        List<User> studentList = session.selectList("cn.company.dao.UserDao.findAllUsers");
        for (User user : studentList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test
    public void testFindUserById01() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        User user = session.selectOne("cn.company.dao.UserDao.findUserById", 2001);
        System.out.println("根据id查询User执行结果： " + user);
        session.close();
    }

    //使用工具类精简代码
    @Test
    public void testFindAllUser02(){
        //获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "cn.company.dao.UserDao.findAllUsers";
        List<User> studentList = sqlSession.selectList(sqlId);
        System.out.println("使用工具类查找所有User的情况：");
        for (User user : studentList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void testFindUserById02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "cn.company.dao.UserDao.findUserById";
        User user = sqlSession.selectOne(sqlId,2008);
        System.out.println("使用工具类根据id查询User执行结果： " + user);
        sqlSession.close();
    }
}
