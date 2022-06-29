package com.vtw.dna.unist.shell;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.FluentProducerTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Map;

/**
 * Shell 명령어를 입력하여 Flow 실행
 */
@Slf4j
@AllArgsConstructor
@ShellComponent
public class ShellCommands {

    private final CamelContext context;
    private final FluentProducerTemplate producerTemplate;

    @ShellMethod("Flow 호출하기. ex) request --flow Flow1 --input {\"x\":10,\"y\":17}")
    public String request(
            @ShellOption(defaultValue = "Flow1") String flow,
            @ShellOption(defaultValue = "{\"x\":10,\"y\":17}") String input) throws JsonProcessingException {

        Map inputMap = new ObjectMapper().readValue(input, Map.class);

        Exchange exchange = producerTemplate.withBody(inputMap).to("direct://" + flow).send();
        Object result = exchange.getMessage().getBody();

        return result.toString();
    }

}
