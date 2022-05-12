package com.adnan.additbackend.bootstrap;

import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.repositories.StoryRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoryBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private StoryRepository storyRepository;

    public StoryBootstrap(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        storyRepository.saveAll(getStories());
    }

    private List<Story> getStories(){
        List<Story> stories = new ArrayList<>(2);

        return stories;
    }
}
