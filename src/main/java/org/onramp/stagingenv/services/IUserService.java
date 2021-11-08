package org.onramp.stagingenv.services;

import org.onramp.stagingenv.model.User;

public interface IUserService {

    User getUser(String userId);
}
