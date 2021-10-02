package com.example.serverwithembeddedclient.async;

import com.example.serverwithembeddedclient.model.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class Clock implements Runnable {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    private final AtomicBoolean running = new AtomicBoolean(false);

    @Override
    public void run() {
        running.set(true);
        while (running.get()) {
            try {
                GenericMessage message = new GenericMessage(HtmlUtils.htmlEscape(new SimpleDateFormat("HH:mm:ss").format(new Date())));
                messagingTemplate.convertAndSend("/topic/clock", message);
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        if (!running.get()) {
            new Thread(this).start();
        }
    }

    public void stop() {
        running.set(false);
    }
}
