package cn.company.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * description: Mybatis整合工具类
 * author: 
 * create time:  2021/9/2 16:22
 */
public class MybatisUtils {
    private static SqlSessionFactory factory = null;

    static {
        String config = "mybatis.xml"; //和项目中的mybatis配置文件的名称一致
        try {
            InputStream in = Resources.getResourceAsStream(config);
            //创建SqlSessionFactory对象，使用SqlSessionFactoryBuild
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession的方法
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();// 非自动提交事务
        }
        return sqlSession;
    }
}