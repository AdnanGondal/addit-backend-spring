package com.adnan.additbackend.controllers;

import com.adnan.additbackend.services.StoryService;
import com.adnan.additbackend.services.VoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class StoryControllerTest {

    @Mock
    StoryService storyService;

    @Mock
    VoteService voteService;

    StoryController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new StoryController(storyService,voteService);
    }

    @Test
    void all() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/api/"))
                        .andExpect(status().isOk());
    }
}