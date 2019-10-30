package org.wildfly.swarm.ts.microprofile.restclient.fault.tolerance;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@ApplicationScoped
public class HelloResource {
    private volatile boolean ok = true;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Hello get() {
        if (ok) {
            return new Hello("Hello, world!");
        } else {
            throw new WebApplicationException("DISABLED");
        }
    }

    @POST
    @Path("/enable")
    public void enable() {
        ok = true;
    }

    @POST
    @Path("/disable")
    public void disable() {
        ok = false;
    }
}
