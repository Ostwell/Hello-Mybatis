package cn.company;

import cn.company.util.MybatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * description: 测试类-删除
 * author:
 * create time:  2021/9/2 17:27
 */
public class TestDeleteUser {
    @Test
    public void testDeleteUserById01() throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);//自动提交

        String sqlId = "cn.company.dao.UserDao.deleteUserById";
        int nums = sqlSession.delete(sqlId, 2008);
        System.out.println("执行delete的结果=" + nums);
        sqlSession.close();
    }

    //使用工具类精简代码
    @Test
    public void testDelete02() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "cn.company.dao.UserDao.deleteUserById";
        int num = sqlSession.delete(sqlId, 2004);
        sqlSession.commit();//增删改记得提交

        System.out.println("使用工具类delete的执行结果： " + num);
        sqlSession.close();
    }
}