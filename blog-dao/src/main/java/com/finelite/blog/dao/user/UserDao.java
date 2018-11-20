package com.finelite.blog.dao.user;

import com.finelite.blog.entity.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//标志位Mybatis 的Mapper
public interface UserDao {

    /**
     * 列出所有用户
     * @return
     */
    @Select("SELECT * FROM user ORDER BY NICK_NAME")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "nickName", column = "NICK_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "createdTime", column = "CREATED_TIME"),
            @Result(property = "updatedBy", column = "UPDATED_BY"),
            @Result(property = "updatedTime", column = "UPDATED_TIME")
    })
    List<User> showAll();

    /**
     * 根据UserName查询用户信息
     * @param name
     * @return
     */
    @Select("SELECT * FROM user WHERE NICK_NAME=#{name}")
    //根据UserName查询User信息
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "nickName", column = "NICK_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "createdTime", column = "CREATED_TIME"),
            @Result(property = "updatedBy", column = "UPDATED_BY"),
            @Result(property = "updatedTime", column = "UPDATED_TIME")
    })
    List<User> selectByName(String name);

    //根据UserID查询User信息
    @Select("SELECT * FROM user WHERE ID=#{id}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "nickName", column = "NICK_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "createdTime", column = "CREATED_TIME"),
            @Result(property = "updatedBy", column = "UPDATED_BY"),
            @Result(property = "updatedTime", column = "UPDATED_TIME")
    })
    User selectByID(String id);

    /**
     * 插入新User
     * @param user
     * @return
     */
    @Insert("INSERT INTO testuser(NICK_NAME,PASSWORD,CREATED_TIME,UPDATED_BY,UPDATED_TIME)"
            + "VALUES(#{nickName},#{password},#{createdTime},#{updatedBy},#{updatedTime})")
    public void addUser(User user);

    /**
     * 根据用户ID更新用户信息（ID唯一标识）
     * @param user
     */

    @Update("UPDATE user SET NICK_NAME=#{name},PASSWORD=#{password},CREATED_TIME=#{createdTime}" +
            ",UPDATED_BY=#{updatedBy},UPDATED_TIME=#{updatedTime} WHERE ID=#{id}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "nickName", column = "NICK_NAME"),
            @Result(property = "password", column = "PASSWORD"),
            @Result(property = "createdTime", column = "CREATED_TIME"),
            @Result(property = "updatedBy", column = "UPDATED_BY"),
            @Result(property = "updatedTime", column = "UPDATED_TIME")
    })
    public void updateByUserID(User user);

    /**
     * 根据用户ID删除用户信息（ID唯一标识）
     * @param id
     * @return
     */
    @Delete("DELETE FROM user WHERE ID=#{id}")
    public void deleteByUserID(String id);

}
