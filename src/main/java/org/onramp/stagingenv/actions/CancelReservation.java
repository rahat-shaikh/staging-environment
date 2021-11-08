package org.onramp.stagingenv.actions;

import org.onramp.stagingenv.model.Claim;
import org.onramp.stagingenv.model.Status;
import org.onramp.stagingenv.services.ClaimService;
import org.onramp.stagingenv.services.IClaimService;

public class CancelReservation{

    IClaimService claimService = new ClaimService();

    public void cancel(String claimId)
    {
        Claim claim = claimService.removeClaim(Integer.parseInt(claimId));
        if(claim.getStatus().equals(Status.UNACQUIRED))
        {
            System.out.println("Reservation Successfully Cancelled");
        }
    }

}
