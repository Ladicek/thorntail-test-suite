package org.wildfly.swarm.ts.microprofile.restclient.fault.tolerance;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/client")
public class ClientResource {
    @Inject
    @RestClient
    private HelloClient hello;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public CompletionStage<String> get() {
        return hello.get().thenApply(it -> it.value);
    }
}
