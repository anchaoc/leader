package com.ac.learn.config.listener.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author anchao
 * @date 2020/8/10 16:10
 **/
public class PersonEvent  extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PersonEvent(Object source,Person person) {
        super(source);
        this.person = person;
    }

    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
