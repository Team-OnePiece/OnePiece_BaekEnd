package com.example.onepiece.domain.user.service.facade;

import com.example.onepiece.domain.user.repository.UserRepository;
import com.example.onepiece.domain.user.entity.User;
import com.example.onepiece.global.error.ErrorCode;
import com.example.onepiece.global.error.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getCurrentUser(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
    }
}
