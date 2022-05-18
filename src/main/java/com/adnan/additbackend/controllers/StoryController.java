package com.adnan.additbackend.controllers;


import com.adnan.additbackend.models.Direction;
import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.models.Vote;
import com.adnan.additbackend.services.StoryService;
import com.adnan.additbackend.services.VoteService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class StoryController {

    private final StoryService storyService;
    private final VoteService voteService;

    public StoryController(StoryService storyService, VoteService voteService) {
        this.storyService = storyService;
        this.voteService = voteService;
    }

    @GetMapping({"/",""})
    public String helloWorld(){
        return "Welcome to the Addit Backend API";
    }

    @GetMapping({"/stories","/stories/"})
    public Iterable<Story> all(){


        return storyService.getAllStories();
    }

    @PostMapping({"/story","/story/"})
    public String newStory(@RequestBody Story story) {

        storyService.saveStory(story);
        return "STORY SUCCESSFULLY ADDED";
    }

   @PostMapping({"/stories/{id}/votes"})
    public String newVote(@PathVariable Long id, @RequestBody VoteJSON voteJSON){

        voteService.saveVote(id,voteJSON.getDirection());


        return "VOTED SUCCESFULLY";
    }

}
