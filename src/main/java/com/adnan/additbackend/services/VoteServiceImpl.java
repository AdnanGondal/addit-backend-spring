package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Direction;
import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.models.Vote;
import com.adnan.additbackend.repositories.StoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private final StoryRepository storyRepository;

    public VoteServiceImpl(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    public void saveVote(Long storyId, Direction direction) {

        Optional<Story> storyOptional = storyRepository.findById(storyId);

        // TO ERROR HANDLE
        Story story = storyOptional.get();

        story.addVote(new Vote(direction));
        storyRepository.save(story);
    }
}
