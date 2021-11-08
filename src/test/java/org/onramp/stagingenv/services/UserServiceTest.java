package org.onramp.stagingenv.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.onramp.stagingenv.dao.UserDao;
import org.onramp.stagingenv.model.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    UserService userService;
    @Mock
    UserDao userDao = null;
    private String userName = "user@mail.com";

    @Before
    public void setup(){
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);
     }

    @Test
    public void testGetUser()
    {
        User user = new User();
        user.setName("User");
        user.setUserName("user@mail.com");
        user.setId(1);

        when(userDao.getUser(userName))
                .thenReturn(user);
        User result = userService.getUser(userName);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getUserName(),userName);
    }

}
