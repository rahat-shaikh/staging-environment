package org.onramp.stagingenv.services;

import org.onramp.stagingenv.model.Environment;

import java.util.List;

public interface IEnvironmentService {

    List<Environment> getEnvironments();

}
