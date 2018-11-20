package com.finelite.blog.serviceimpl.user;


import com.finelite.blog.dao.user.UserDao;
import com.finelite.blog.entity.user.User;
import com.finelite.blog.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> showAll() {
        return userDao.showAll();
    }

    @Override
    public List<User> selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public User selectByID(String id) {
        User user=userDao.selectByID(id);

        return user;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateByUserID(User user) {
        userDao.updateByUserID(user);
    }

    @Override
    public void deleteByUserID(String id) {
        userDao.deleteByUserID(id);
    }
}
