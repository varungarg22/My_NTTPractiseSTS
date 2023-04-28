package com.codedecode.KafkaDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.KafkaDemo.service.KafkaProducer;

@RestController
@RequestMapping("/rest/api")
public class FetchMessageFromClient {

	@Autowired
    KafkaProducer kafkaProducer;


    @GetMapping(value = "/producer")
    public String sendMessage(@RequestParam("message") String message)
    {
        kafkaProducer.sendMessageToTopic(message);
        return "Message sent Successfully to the your code decode topic ";
    }
    //set JAVA_HOME=C:\Program Files\Java\jdk-17
    // .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
    //.\bin\windows\kafka-server-start.bat .\config\server.properties
	
}
