package com.soft.docker;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DockerController {

    private final SenderService senderService;

    @GetMapping("/test")
    public ResponseEntity send(){
        senderService.send();
        return ResponseEntity
                .status(HttpStatus.OK).build();
    }



}
