package org.onramp.stagingenv.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Claim {

   @EqualsAndHashCode.Include private int id;
    private Environment environment;
    private User user;
    private String token;
    private Status status;
    private String startDate;
    private String endDate;
}
