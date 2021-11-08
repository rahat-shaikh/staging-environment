package org.onramp.stagingenv.actions;

import org.onramp.stagingenv.model.Environment;
import org.onramp.stagingenv.services.EnvironmentService;
import org.onramp.stagingenv.services.IEnvironmentService;

import java.util.List;

public class ViewEnvironment{

    IEnvironmentService service = new EnvironmentService();

    public void getEnvironments()
    {
        service.getEnvironments().forEach(
                environment -> {
                    System.out.println("Environment name :"+environment.getName());
                    System.out.println("Environment Status :"+ environment.getStatus().getValue());
                }
        );
    }
}
