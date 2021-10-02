package com.example.serverwithembeddedclient.controller;

import com.example.serverwithembeddedclient.async.Clock;
import com.example.serverwithembeddedclient.model.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @Autowired
    private Clock clock;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public GenericMessage greeting(GenericMessage message) throws Exception {
        clock.start();
        return new GenericMessage("Hello, " + HtmlUtils.htmlEscape(message.getContent()) + "!");
    }

}
