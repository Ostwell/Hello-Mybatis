package cn.company.dao;

import cn.company.entity.User;

import java.util.List;

/**
 * description: UserDao
 * author: 
 * create time:  2021/9/2 15:52
 */
public interface UserDao {

    User findUserById(int id);

    List<User> findAllUsers();

    int insertUser(User user);

    int deleteUserById(int id);

    int modifyUser(User user);

}
