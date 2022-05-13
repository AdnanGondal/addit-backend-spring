package com.adnan.additbackend.services;

import com.adnan.additbackend.models.Direction;

public interface VoteService {

    void saveVote(Long storyId, Direction Direction);
}
