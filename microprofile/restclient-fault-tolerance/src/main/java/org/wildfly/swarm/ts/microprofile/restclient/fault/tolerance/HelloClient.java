package org.wildfly.swarm.ts.microprofile.restclient.fault.tolerance;

import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface HelloClient {
    @GET
    @Path("/rest/hello")
    @Produces(MediaType.APPLICATION_JSON)
    @Asynchronous
    @Fallback(HelloFallback.class)
    @Retry
    CompletionStage<Hello> get();
}
