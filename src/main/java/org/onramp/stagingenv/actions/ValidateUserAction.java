package org.onramp.stagingenv.actions;

import org.onramp.stagingenv.model.User;
import org.onramp.stagingenv.services.IUserService;
import org.onramp.stagingenv.services.UserService;

public class ValidateUserAction {

    IUserService userService = new UserService();
    public void validate(String userName)
    {
       User user =  userService.getUser(userName);
       if(null != user)
       {
           displayMessage(String.format("Welcome %s ",user.getName()));
       }else {
           displayMessage(String.format("User %s doesn't exist. Exiting Application",userName));
           System.exit(0);
       }

    }

    private void displayMessage(String message)
    {
        System.out.println(message);
    }
}
