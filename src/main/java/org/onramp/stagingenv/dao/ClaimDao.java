package org.onramp.stagingenv.dao;

import org.onramp.stagingenv.model.Claim;
import org.onramp.stagingenv.model.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClaimDao implements IDao<Claim>,IClaimDao{

    private static List<Claim> claimList = new ArrayList<>();

    @Override
    public void setup(List<Claim> list) {
        claimList = list;
    }

    @Override
    public Claim saveClaim(Claim claim) {
        claim.setId(getId());
        claim.setStatus(Status.ACQUIRED);
        claimList.add(claim);
        return claim;
    }

    @Override
    public Claim removeClaim(Claim claim) {
        System.out.println("Size of Claim List before"+ claimList.size());
        claimList.remove(claim);
        claim.setStatus(Status.UNACQUIRED);
        System.out.println("Size of Claim List after"+ claimList.size());
        return claim;
    }

    @Override
    public List<Claim> getClaims() {
        return claimList;
    }

    @Override
    public Claim getClaim(int claimId) {
        return (Claim) claimList.stream().filter(claim -> claim.getId() == claimId).toArray()[0];
    }

    private int getId()
    {
        return Math.abs(new Random().nextInt());
    }


}
