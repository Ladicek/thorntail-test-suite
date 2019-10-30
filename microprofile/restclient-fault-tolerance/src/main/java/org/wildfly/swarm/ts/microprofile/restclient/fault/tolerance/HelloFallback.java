package org.wildfly.swarm.ts.microprofile.restclient.fault.tolerance;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.completedFuture;

public class HelloFallback implements FallbackHandler<CompletionStage<Hello>> {
    @Override
    public CompletionStage<Hello> handle(ExecutionContext context) {
        return completedFuture(new Hello("Fallback"));
    }
}
