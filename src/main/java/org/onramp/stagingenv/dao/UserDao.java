package org.onramp.stagingenv.dao;

import org.onramp.stagingenv.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDao<T> implements IDao<User>, IUserDao{

    private static List<User> userList;

    @Override
    public void setup(List<User> list) {
        userList = list;
    }

    @Override
    public User getUser(String userId) {
        List<User> users =  userList.stream()
              .filter(user -> user.getUserName().equalsIgnoreCase(userId))
              .collect(Collectors.toList());
      if(users.size()>0)
      {
          return users.get(0);
      }else {
          return null;
      }
    }
}
