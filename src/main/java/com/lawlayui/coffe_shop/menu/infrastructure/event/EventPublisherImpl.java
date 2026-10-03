package com.lawlayui.coffe_shop.menu.infrastructure.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.lawlayui.coffe_shop.menu.application.out.EventPublisher;
 
@Service 
public class EventPublisherImpl implements EventPublisher{
    private ApplicationEventPublisher applicationEventPublisher;

    public EventPublisherImpl(ApplicationEventPublisher publisher) {
        this.applicationEventPublisher = publisher;
    }

    @Override 
    public void publish(Object event) {
        applicationEventPublisher.publishEvent(event);
    }
}
