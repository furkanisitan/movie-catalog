package com.furkanisitan.moviecatalog.webmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("genres")
public class GenresController {

    @GetMapping("")
    public String index() {
        return "genres/index";
    }

}
