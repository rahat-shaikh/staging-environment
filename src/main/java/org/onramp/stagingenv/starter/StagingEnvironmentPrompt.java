package org.onramp.stagingenv.starter;

import org.onramp.stagingenv.actions.CancelReservation;
import org.onramp.stagingenv.actions.ClaimEnvironmentAction;
import org.onramp.stagingenv.actions.ValidateUserAction;
import org.onramp.stagingenv.actions.ViewEnvironment;
import org.onramp.stagingenv.dao.EnvironmentDao;
import org.onramp.stagingenv.dao.IDao;
import org.onramp.stagingenv.dao.UserDao;
import org.onramp.stagingenv.model.Environment;
import org.onramp.stagingenv.model.Status;
import org.onramp.stagingenv.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StagingEnvironmentPrompt {

    private static final ClaimEnvironmentAction environmentAction = new ClaimEnvironmentAction();
    private static final ViewEnvironment viewEnvironment = new ViewEnvironment();
    private static final CancelReservation cancelReservation = new CancelReservation();
    private static final ValidateUserAction validateUserAction = new ValidateUserAction();



    public static void main(String[] args) {

        StagingEnvironmentPrompt stagingEnvironmentPrompt = new StagingEnvironmentPrompt();
        stagingEnvironmentPrompt.dataSetup();
        Scanner stagingScanner = new Scanner(System.in);
        System.out.println("Welcome to The Rehearsal");

        while (true){
            System.out.println("View environments: Enter 1");
            System.out.println("Reserve environment: Enter 2");
            System.out.println("Cancel Reservation: Enter 3");

            String optionViewEnv = stagingScanner.nextLine();

            switch (optionViewEnv)
            {
                case "1":
                    System.out.println("Environment List::");
                    viewEnvironment.getEnvironments();
                    break;
                case "2":
                    System.out.println("Enter your User Id:");
                    String email = stagingScanner.nextLine();

                    validateUserAction.validate(email);
                    System.out.println("Enter Start Date in MM/DD/YYYY format");
                    String startDate = stagingScanner.nextLine();
                    System.out.println("Enter End Date in MM/DD/YYYY format");
                    String endDate = stagingScanner.nextLine();
                    environmentAction.claimEnvironment(email,startDate,endDate);
                    break;
                case "3":
                    System.out.println("Enter Claim id");
                    String claimId = stagingScanner.nextLine();
                    cancelReservation.cancel(claimId);
                    break;
                default:
                    System.out.println("Incorrect Option");
            }

        }

    }

    private static void dataSetup()
    {
        IDao iDao = new EnvironmentDao();
        List<Environment> environments = new ArrayList<>();
        Environment environment = new Environment();
        environment.setId(Math.abs(new Random().nextInt()));
        environment.setName("North");
        environment.setStatus(Status.UNACQUIRED);
        Environment environment1 = new Environment();
        environment1.setId(Math.abs(new Random().nextInt()));
        environment1.setName("South");
        environment1.setStatus(Status.UNACQUIRED);
        environments.add(environment);
        environments.add(environment1);
        iDao.setup(environments);

        IDao iDao1 = new UserDao();
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(Math.abs(new Random().nextInt()));
        user.setUserName("tom@gmail.com");
        user.setName("Tom");
        users.add(user);

        User user1 = new User();
        user1.setId(Math.abs(new Random().nextInt()));
        user1.setUserName("jerry@gmail.com");
        user1.setName("Jerry");
        users.add(user1);

        User user2 = new User();
        user2.setId(Math.abs(new Random().nextInt()));
        user2.setUserName("simba@gmail.com");
        user2.setName("Simba");
        users.add(user2);


        iDao1.setup(users);


    }
}
