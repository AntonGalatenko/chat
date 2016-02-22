package com.toxa.spring.ajax.chat.controller;

import com.toxa.spring.ajax.chat.domain.Message;
import com.toxa.spring.ajax.chat.domain.Messages;
import com.toxa.spring.ajax.chat.domain.thread.DistributorForThread;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    Messages msg = Messages.getInstance();

    @RequestMapping(value = {"/", "login**"})
    public ModelAndView loginPage(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView redirectIndexPage(@RequestParam String user){
        return new ModelAndView("chat", "author", user);
    }

    @RequestMapping(value = "/index**")
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
    public @ResponseBody String getMsg(@PathVariable int n){

        System.out.println("get " + n);
        String result = new DistributorForThread().get(n);


        return result;
    }
}
