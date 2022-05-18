package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.repositories.StoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoryServiceIT {

    @Autowired
    StoryService storyService;

    @Autowired
    StoryRepository storyRepository;

    @Test
    void getAllStories() {
        Set<Story> stories = storyService.getAllStories();

        System.out.println(stories.size());
    }

    @Test
    void saveStory() {
    }
}