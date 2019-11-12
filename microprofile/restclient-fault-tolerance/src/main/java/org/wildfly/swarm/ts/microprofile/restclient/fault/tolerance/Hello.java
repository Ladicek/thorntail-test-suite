package org.wildfly.swarm.ts.microprofile.restclient.fault.tolerance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Hello {
    public final String value;

    @JsonCreator
    public Hello(@JsonProperty("value") String value) {
        this.value = value;
    }
}
