package org.onramp.stagingenv.services;

import org.onramp.stagingenv.model.Claim;

public interface IClaimService {

     Claim claimEnvironment(String userName,String startDate, String endDate);

     Claim removeClaim(int claimId);
}
