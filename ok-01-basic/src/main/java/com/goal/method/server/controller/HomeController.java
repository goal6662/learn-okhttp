package com.goal.method.server.controller;

import com.goal.method.server.domain.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/")
    public String name(@RequestHeader(value = "Env", required = false, defaultValue = "xyz") String env) {
        return "Home Page " + env;
    }

    @GetMapping("/search")
    public String search(@RequestParam("kw") String kw) {
        return "Get keyword " + kw;
    }


    @PostMapping("/insert")
    public String insert(@RequestBody Person person) {
        return "Person info " + person;
    }

}
