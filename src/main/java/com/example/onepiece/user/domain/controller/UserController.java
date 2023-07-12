package com.example.onepiece.user.domain.controller;

import com.example.onepiece.user.domain.controller.dto.request.IdDuplicateRequest;
import com.example.onepiece.user.domain.controller.dto.request.NicknameDuplicateRequest;
import com.example.onepiece.user.domain.controller.dto.request.UserLoginRequest;
import com.example.onepiece.user.domain.controller.dto.request.UserSignUpRequest;
import com.example.onepiece.user.domain.service.DuplicateService;
import com.example.onepiece.user.domain.service.UserLoginService;
import com.example.onepiece.user.domain.service.UserSignUpService;
import com.example.onepiece.user.global.security.Jwt.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name = "UserAPI입니다")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserSignUpService userSignUpService;
    private final DuplicateService duplicateService;
    private final UserLoginService userLoginService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.userSignUp(request);
    }

    @Operation(summary = "아이디 중복확인")
    @GetMapping("/id/Duplicate")
    public void userIdDuplicate(@RequestBody IdDuplicateRequest request) {
        duplicateService.checkUserIdDuplicate(request);
    }

    @Operation(summary = "별명 중복확인")
    @GetMapping("/nickname/Duplicate")
    public void nicknameDuplicate(@RequestBody NicknameDuplicateRequest request) {
        duplicateService.checkNicknameDuplicate(request);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginRequest request) {
        return userLoginService.userLogin(request);
    }
}
