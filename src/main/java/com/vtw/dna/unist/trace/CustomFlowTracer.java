package com.vtw.dna.unist.trace;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.NamedNode;
import org.apache.camel.NamedRoute;
import org.apache.camel.impl.engine.DefaultTracer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomFlowTracer extends DefaultTracer {

    @Override
    public void traceBeforeNode(NamedNode node, Exchange exchange) {
        super.traceBeforeNode(node, exchange);
        log.info("traceBeforeNode");
    }

    @Override
    public void traceAfterNode(NamedNode node, Exchange exchange) {
        super.traceAfterNode(node, exchange);
        log.info("traceAfterNode");
    }

    @Override
    public void traceBeforeRoute(NamedRoute route, Exchange exchange) {
        super.traceBeforeRoute(route, exchange);
        log.info("traceBeforeRoute");
    }

    @Override
    public void traceAfterRoute(NamedRoute route, Exchange exchange) {
        super.traceAfterRoute(route, exchange);
        log.info("traceAfterRoute");
    }

}
