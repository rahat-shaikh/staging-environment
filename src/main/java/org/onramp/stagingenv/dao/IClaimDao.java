package org.onramp.stagingenv.dao;

import org.onramp.stagingenv.model.Claim;

import java.util.List;

public interface IClaimDao {

    Claim saveClaim(Claim claim);


    Claim removeClaim(Claim claim);

    List<Claim> getClaims();

    Claim getClaim(int claimId);
}
