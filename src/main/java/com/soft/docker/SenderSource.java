package com.soft.docker;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

interface TestSource {

    String OUTPUT = "soheeTopic1";

    @Output(TestSource.OUTPUT)
    MessageChannel messageOutput();
}

@Component
@EnableBinding(TestSource.class)
public class SenderSource{

    private final MessageChannel messageChannel;

    @Autowired
    public SenderSource(@Qualifier(TestSource.OUTPUT) MessageChannel messageChannel){
        this.messageChannel = messageChannel;
    }

    public void send( Map<String, String> msg){
        messageChannel.send(MessageBuilder.withPayload(msg).build());
    }
}


