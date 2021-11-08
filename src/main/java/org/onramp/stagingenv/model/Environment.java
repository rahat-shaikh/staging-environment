package org.onramp.stagingenv.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
public class Environment {
   private int id;
   private String name;
   private List<Server> servers;
   private Status status;
}
