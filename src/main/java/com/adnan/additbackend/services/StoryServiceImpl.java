package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Direction;
import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.repositories.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public Set<Story> getAllStories() {

        Set<Story> stories = new LinkedHashSet<>();

        Iterator<Story> repo = storyRepository.findAll().iterator();

        repo.forEachRemaining(story -> {

            story.getVotes().iterator().forEachRemaining(vote->{
                Direction direction = vote.getDirection();

                if (direction.toString().equals("UP")){
                    story.setUpvotes(story.getUpvotes()+1);
                } else {
                    story.setDownvotes(story.getDownvotes()-1);
                }

            });
            stories.add(story);
        });

        return stories;
    }

    @Override
    public void saveStory(Story story) {
        storyRepository.save(story);
    }


}
