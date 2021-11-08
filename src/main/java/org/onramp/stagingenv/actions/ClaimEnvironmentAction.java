package org.onramp.stagingenv.actions;

import org.onramp.stagingenv.model.Claim;
import org.onramp.stagingenv.services.ClaimService;
import org.onramp.stagingenv.services.IClaimService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ClaimEnvironmentAction{

    private IClaimService claimService = new ClaimService();
    DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
    public void claimEnvironment(String userName, String startDate, String endDate)
    {
        Claim claim = null;

         try {
             Date startD = parser.parse(startDate);
             Date endD = parser.parse(endDate);
             long diff = endD.getTime() - startD.getTime();
             if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)> 5)
             {
                 System.err.println("Reservation cannot be greater than 5 days");
             }else {
                 claim = claimService.claimEnvironment(userName, startDate, endDate);
                 handleResponse(claim);

             }
        }catch (ParseException p)
         {
             System.err.println("Please enter valid date");
         } catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }

    private void handleResponse(Claim claim)
    {
        String msg = "";
        switch (claim.getStatus())
        {
            case ACQUIRED:
                 msg = String.format("You have successfully reserved the environment %s with claim id %s",
                         claim.getEnvironment().getName(), claim.getId());
                break;
            case UNACQUIRED:
                msg = "No environment available";
                break;
            default:
                msg = "There was an error processing your request. Please try again later";
        }
        displayMessage(msg);
    }

    private void displayMessage(String message)
    {
        System.out.println(message);
    }

}
