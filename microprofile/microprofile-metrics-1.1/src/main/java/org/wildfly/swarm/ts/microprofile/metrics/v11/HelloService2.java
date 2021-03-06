package org.wildfly.swarm.ts.microprofile.metrics.v11;

import java.util.Random;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.metrics.annotation.Counted;

@ApplicationScoped
public class HelloService2 {
    @Counted(
            monotonic = true,
            name = "hello-count",
            absolute = true,
            displayName = "Hello Count",
            description = "Number of hello invocations",
            reusable = true
    )
    public String hello() throws InterruptedException {
        Thread.sleep(new Random().nextInt(100) + 1);
        return "Hello from 2nd counted method";
    }
}
