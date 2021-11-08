package org.onramp.stagingenv.services;

import org.onramp.stagingenv.dao.EnvironmentDao;
import org.onramp.stagingenv.dao.IEnvironmentDao;
import org.onramp.stagingenv.model.Environment;

import java.util.List;

public class EnvironmentService implements IEnvironmentService{

    IEnvironmentDao environmentDao = new EnvironmentDao();

    @Override
    public List<Environment> getEnvironments() {
        return environmentDao.getEnvironments();
    }
}
