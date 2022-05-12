package com.adnan.additbackend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StoryController {

    @GetMapping({"/",""})
    public String helloWorld(){
        return "Welcome to the Addit Backend API";
    }

    @GetMapping({"/stories","/stories/"})
    public String getAllStories(){
        return "ALL STORIES HERE";
    }
}
