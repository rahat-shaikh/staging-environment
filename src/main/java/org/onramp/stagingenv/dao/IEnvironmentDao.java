package org.onramp.stagingenv.dao;

import org.onramp.stagingenv.model.Environment;

import java.util.List;

public interface IEnvironmentDao {

    List<Environment> getEnvironments();


}
