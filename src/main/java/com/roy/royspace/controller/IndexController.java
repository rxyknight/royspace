package com.roy.royspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(Model model) {
        return "index";
    }
}
