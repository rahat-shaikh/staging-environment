package org.onramp.stagingenv.dao;

import org.onramp.stagingenv.model.User;

public interface IUserDao {

    User getUser(String userId);
}
