package com.furkanisitan.moviecatalog.webmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("actors")
public class ActorController {


    @GetMapping({"", "/index"})
    public String showList() {
        return "actor/index";
    }


}
