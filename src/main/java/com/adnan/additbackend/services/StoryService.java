package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Story;

import java.util.Set;


public interface StoryService {

    Iterable<Story> getAllStories();

    void saveStory(Story story);
}
