package com.example.onepiece.domain.user.facade;

import com.example.onepiece.domain.user.domain.User;
import com.example.onepiece.domain.user.domain.repository.UserRepository;
import com.example.onepiece.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByUserId(accountId);
    }

    public User getUserByUserId(String accountId) {
        return userRepository.findByUserId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
