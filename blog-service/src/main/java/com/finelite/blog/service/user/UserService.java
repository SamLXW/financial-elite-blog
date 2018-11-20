package com.finelite.blog.service.user;

import com.finelite.blog.entity.user.User;

import java.util.List;

public interface UserService {


    /**
     * 列出所有用户信息
     */
    List<User> showAll();
    /**
     * 根据用户名称查询用户信息
     */
    List<User> selectByName(String name);
    /**
     * 增加用户信息
     * @return
     */
    User selectByID(String id);

//    User selectByName(String name);

    public void addUser(User user);
    /**
     * 根据UserID更新用户信息
     */
    public void updateByUserID(User user);
//    /**
//     * 根据UserName更新用户信息
//     */
//    public void updateByUserName(User user);
    /**
     * 根据UserID删除用户信息
     * @param id
     * @return
     */
    public void deleteByUserID(String id);
    /**
     * 根据UserName删除用户信息
     * @param name
     * @return
     */
//    public void deleteByUserName(String name);

}
