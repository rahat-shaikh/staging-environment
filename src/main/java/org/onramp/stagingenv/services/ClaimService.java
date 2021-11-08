package org.onramp.stagingenv.services;

import org.onramp.stagingenv.dao.ClaimDao;
import org.onramp.stagingenv.dao.IClaimDao;
import org.onramp.stagingenv.model.Claim;
import org.onramp.stagingenv.model.Environment;
import org.onramp.stagingenv.model.Status;
import java.util.List;
import java.util.stream.Collectors;

public class ClaimService implements IClaimService {

    IUserService userService = new UserService();
    IClaimDao claimDao = new ClaimDao();
    IEnvironmentService environmentService = new EnvironmentService();

    @Override
    public Claim claimEnvironment(String userName, String startDate, String endDate){

       List<Environment> environments = environmentService.getEnvironments();
       List<Claim> claimList = claimDao.getClaims().stream()
               .filter(claim -> claim.getUser().getUserName().equalsIgnoreCase(userName))
               .collect(Collectors.toList());
        Claim claim = new Claim();
        if(claimList.size() > 0)
        {
           throw new RuntimeException("Reservation Already Exists");
        }
       List<Environment> filteredList = environments.stream().filter(env -> env.getStatus().equals(Status.UNACQUIRED))
               .collect(Collectors.toList());

        if (filteredList.size() > 0)
       {
           Environment environment = filteredList.get(0);
           environment.setStatus(Status.ACQUIRED);
           claim.setEnvironment(environment);
           claim.setUser(userService.getUser(userName));
           claim.setToken("Token Expiring in X secs"); //access token for end date
           claim.setStartDate(startDate);
           claim.setEndDate(endDate);
           claimDao.saveClaim(claim);
       }else {
            claim.setStatus(Status.UNACQUIRED);
        }
       return claim;
    }

    @Override
    public Claim removeClaim(int claimId) {
      Claim claim =  claimDao.getClaim(claimId);
      claim.setId(claimId);

     Environment env = (Environment) environmentService.getEnvironments().stream()
             .filter(environment -> environment.getId() == claim.getEnvironment().getId()).toArray()[0];
        env.setStatus(Status.UNACQUIRED);
      return claimDao.removeClaim(claim);
    }

}
