package com.assesment.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assessment")
public class ProducerController {


    @Autowired
    private FirstProducer firstProducer;
    @Autowired
    private SecondProducer secondProducer;


    @GetMapping("/firstProducer")
    public String firstProducer() {

        return firstProducer.sendEventFromFirstProducer();
    }


    @GetMapping("/secondProducer")
    public String secondProducer() {
        return secondProducer.sendEventFromSecondProducer();
    }




}
