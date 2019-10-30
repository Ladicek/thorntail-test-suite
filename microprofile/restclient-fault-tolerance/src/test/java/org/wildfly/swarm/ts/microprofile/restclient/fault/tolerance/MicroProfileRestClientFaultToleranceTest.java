package org.wildfly.swarm.ts.microprofile.restclient.fault.tolerance;

import org.apache.http.client.fluent.Request;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
@DefaultDeployment
public class MicroProfileRestClientFaultToleranceTest {
    @Test
    @RunAsClient
    public void enabled() throws IOException {
        Request.Post("http://localhost:8080/rest/hello/enable").execute().discardContent();

        String response = Request.Get("http://localhost:8080/rest/client").execute().returnContent().asString();
        assertThat(response).isEqualTo("Hello, world!");
    }

    @Test
    @RunAsClient
    public void disabled() throws IOException {
        Request.Post("http://localhost:8080/rest/hello/disable").execute().discardContent();

        String response = Request.Get("http://localhost:8080/rest/client").execute().returnContent().asString();
        assertThat(response).isEqualTo("Fallback");
    }
}
