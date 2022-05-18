package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Story;

import javax.persistence.SecondaryTable;
import java.util.Set;


public interface StoryService {


    Set<Story> getAllStories();

    void saveStory(Story story);
}
