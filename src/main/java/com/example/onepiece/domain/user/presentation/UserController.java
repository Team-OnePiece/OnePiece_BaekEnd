package com.example.onepiece.domain.user.presentation;

import com.example.onepiece.domain.user.presentation.dto.request.*;
import com.example.onepiece.domain.user.presentation.dto.response.UserInfoResponse;
import com.example.onepiece.domain.user.service.*;
import com.example.onepiece.global.error.exception.CustomException;
import com.example.onepiece.global.security.Jwt.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
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
    private final UserInfoService userInfoService;
    private final UserUpdateService userUpdateService;

    @Operation(summary = "회원가입")
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.userSignUp(request);
    }

    @Operation(summary = "아이디 중복확인")
    @GetMapping("/id/Duplicate/{accountId}")
    public void accountIdDuplicate(@PathVariable String accountId) {
        duplicateService.checkAccountIdDuplicate(accountId);
    }

    @Operation(summary = "별명 중복확인")
    @GetMapping("/nickname/Duplicate/{nickname}")
    public void nicknameDuplicate(@PathVariable String nickname) {
       duplicateService.checkNicknameDuplicate(nickname);
    }

    @Operation(summary = "로그인")
    @PostMapping("/login")
    public TokenResponse login(@RequestBody UserLoginRequest request) {
        return userLoginService.userLogin(request);
    }

    @Operation(summary = "내 정보")
    @GetMapping("/info")
    public UserInfoResponse info(){
        return userInfoService.userInfo();
    }

    @Operation(summary = "별명 수정")
    @PatchMapping("/update")
    public void updateProfile(@RequestBody @Valid UserUpdateRequest request){
        userUpdateService.userProfileUpdate(request);
    }
}
