package com.example.demo.controller;

import com.example.demo.domain.Chat;
import com.example.demo.domain.Greeting;
import com.example.demo.domain.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Chat chat(Chat chat) throws Exception {
        return new Chat(chat.getName(), chat.getMessage());
    }

}