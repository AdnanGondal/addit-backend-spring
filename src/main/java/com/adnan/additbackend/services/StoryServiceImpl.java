package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Direction;
import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.repositories.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;

    public StoryServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public Iterable<Story> getAllStories() {

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
        });

        return storyRepository.findAll();
    }

    @Override
    public void saveStory(Story story) {
        storyRepository.save(story);
    }


}
