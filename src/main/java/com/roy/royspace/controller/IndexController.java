package com.roy.royspace.controller;

import com.roy.royspace.model.ContactForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by royren on 16/9/3.
 */
@Controller
public class IndexController {
    /**
     * index main page
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String index(ContactForm contactForm, Model model) {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/thankyou",method = RequestMethod.POST)
    public String thankyou(){
        System.out.println("hihihi");
        return null;
    }
}
