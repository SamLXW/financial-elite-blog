package com.finelite.blog.entity.user;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class User extends BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */

    private Long id;
    /**
     * 账户昵称
     */
    private String nickName;
    /**
     * 账户密码
     */
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
