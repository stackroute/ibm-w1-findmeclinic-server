package com.stackroute.findmeclinic.notificationservice.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins="*")
public class NotificationService {
	 @MessageMapping("/hello")
	    @SendTo("/topic/greetings")
	    public String greeting(String name) throws Exception {
//	        Thread.sleep(1000); // simulated delay
		 System.out.println("name is"+ name);
		 return name;
//	        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	    }
}
