package org.onramp.stagingenv.dao;

import java.util.List;

public interface IDao<T> {

    void setup(List<T> list);
}
