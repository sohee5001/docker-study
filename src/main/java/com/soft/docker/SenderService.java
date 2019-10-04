package com.soft.docker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SenderService {

    private final SenderSource senderSource;

    public void send(){

        Map<String, String> msg = new HashMap<>();
        msg.put("Name", "sohee");

        senderSource.send(msg);
    }


}
