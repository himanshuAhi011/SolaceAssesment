package com.assesment.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
   @Autowired
   Consumer consumer;


    @GetMapping("/consumed")
    public String consumed() {
        String listString = "";
        for(String message:consumer.quemessage){
            listString += message + "<br>";
        }

        return listString;
    }
}
