package com.toxa.spring.ajax.chat.controller;

import com.toxa.spring.ajax.chat.domain.Message;
import com.toxa.spring.ajax.chat.domain.Messages;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller {

    Messages msg = Messages.getInstance();

    @RequestMapping(value = {"/", "/index**"})
    public ModelAndView indexPage(){
        return new ModelAndView("chat");
    }

    @RequestMapping(value = "sendMsg", method = RequestMethod.POST)
    public @ResponseBody void getMsg(@RequestParam String author,
                                       @RequestParam String message){
        System.out.println(author + ": " + message);
        msg.add(new Message(author, message));
    }

    @RequestMapping(value = "getMsg/{n}")
    public @ResponseBody ArrayList<Message> getMsg(@PathVariable int n){
        return msg.get(n);
    }
}
