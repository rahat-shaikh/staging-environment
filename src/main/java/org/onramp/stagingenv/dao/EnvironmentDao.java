package org.onramp.stagingenv.dao;

import org.onramp.stagingenv.model.Environment;

import java.util.List;

public class EnvironmentDao implements IDao<Environment>, IEnvironmentDao{

    private static List<Environment> environmentList;

    @Override
    public void setup(List<Environment> list) {
        environmentList = list;
    }

    @Override
    public List<Environment> getEnvironments() {
        return environmentList;
    }
}
