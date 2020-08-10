package com.ac.leader.config.listener.event;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author anchao
 * @date 2020/8/10 16:15
 **/
@Controller
@RequestMapping("/")
public class PersonEventController {
    @Resource
    PersonService personService;

    @GetMapping("/testEvent")
    @ResponseBody
    public Person testEvent() {
        return personService.getPerson();
    }
}
