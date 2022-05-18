package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Story;
import com.adnan.additbackend.repositories.StoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoryServiceImplTest {

    StoryServiceImpl storyService;

    @Mock
    StoryRepository storyRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        storyService = new StoryServiceImpl(storyRepository);
    }

    @Test
    void getAllStories() {

        //PREPARE MOCK
        Story story = new Story();
        story.setTitle("Test title");
        story.setPost("Test post");
        story.setUrl("Http");
        HashSet storyData = new HashSet();
        storyData.add(story);

        when(storyRepository.findAll()).thenReturn(storyData);
        // ---

        // CALL METHOD
        Set<Story> stories = storyService.getAllStories();

        // ASSERT
        assertEquals(1,stories.size());
        verify(storyRepository, times(1)).findAll();
    }

    @Test
    void saveStory() {
        Story story = new Story();
        story.setTitle("Test title");
        story.setPost("Test post");
        story.setUrl("Http");

        storyService.saveStory(story);

        verify(storyRepository, times(1)).save(story);
    }
}