package org.onramp.stagingenv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {
    ACQUIRED("Acquired"),
    UNACQUIRED("UnAcquired");

    @Getter private String value;


}
