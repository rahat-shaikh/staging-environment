package org.onramp.stagingenv.services;

import org.onramp.stagingenv.dao.IUserDao;
import org.onramp.stagingenv.dao.UserDao;
import org.onramp.stagingenv.model.User;

public class UserService implements IUserService{

    private IUserDao userDao = null;

    public UserService()
    {
        userDao = new UserDao<User>();
    }

    public UserService(IUserDao userDao)
    {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String userId) {
        return userDao.getUser(userId);
    }
}
