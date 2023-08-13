package com.example.onepiece.domain.star.facade;

import com.example.onepiece.domain.feed.domain.Feed;
import com.example.onepiece.domain.star.domain.repository.StarRepository;
import com.example.onepiece.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StarFacade {

    private final StarRepository starRepository;

    public boolean hasUserGivenStarToBoard(User user, Feed board) {
        return starRepository.existsByUserAndBoard(user, board);
    }
}
