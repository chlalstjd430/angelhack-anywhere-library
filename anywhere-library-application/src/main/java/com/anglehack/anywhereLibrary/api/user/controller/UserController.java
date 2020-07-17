package com.anglehack.anywhereLibrary.api.user.controller;

import com.anglehack.anywhereLibrary.api.user.request.SignInRequest;
import com.anglehack.anywhereLibrary.api.user.request.SignUpRequest;
import com.anglehack.anywhereLibrary.api.user.response.CheckDuplicateResponse;
import com.anglehack.anywhereLibrary.api.user.response.SignInResponse;
import com.anglehack.anywhereLibrary.api.auth.JwtTokenProvider;
import com.anglehack.anywhereLibrary.api.user.dto.SimpleUser;
import com.anglehack.anywhereLibrary.api.user.entity.User;
import com.anglehack.anywhereLibrary.api.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/users")
public class UserController {
    @Value("${JWT_SECRET}")
    private String secretKey;

    @Value("${JWT_EXPIRATION}")
    private int expirationDate;

    private final UserService userService;

    @ApiOperation("회원가입")
    @PostMapping("/user/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public SignInResponse signUp(@RequestBody SignUpRequest signUpRequest){
        User user = userService.signUp(signUpRequest.of());

        return SignInResponse.builder()
                .simpleUser(SimpleUser.of(user))
                .accessToken(JwtTokenProvider.getInstance().generateAccessKey(user, secretKey, expirationDate))
                .refreshToken(JwtTokenProvider.getInstance().generateRefreshToken(user, secretKey))
                .build();
    }

    @ApiOperation("로그인")
    @PostMapping("/user/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest){
        User user = userService.signIn(signInRequest.getIdentification(), signInRequest.getPassword());

        return SignInResponse.builder()
                .simpleUser(SimpleUser.of(user))
                .accessToken(JwtTokenProvider.getInstance().generateAccessKey(user, secretKey, expirationDate))
                .refreshToken(JwtTokenProvider.getInstance().generateRefreshToken(user, secretKey))
                .build();
    }

    @ApiOperation("아이디 중복 체크")
    @GetMapping("/user/verification/identification/{identification}")
    @ResponseStatus(HttpStatus.OK)
    public CheckDuplicateResponse checkDuplicateIdentification(@PathVariable String identification) {
        userService.checkDuplicateUserIdentification(identification);

        return new CheckDuplicateResponse("사용 가능한 아이디입니다.");
    }

    @ApiOperation("닉네임 중복 체크")
    @GetMapping("/user/verification/nickname/{nickname}")
    @ResponseStatus(HttpStatus.OK)
    public CheckDuplicateResponse checkDuplicateUserNickname(@PathVariable String nickname) {
        userService.checkDuplicateUserNickname(nickname);

        return new CheckDuplicateResponse("사용 가능한 닉네임입니다.");
    }
}
