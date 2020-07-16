package com.anglehack.anywhereLibrary.api.user.controller;

import com.anglehack.anywhereLibrary.api.user.request.SignUpRequest;
import com.anglehack.anywhereLibrary.api.user.response.SignInResponse;
import com.anglehack.anywhereLibrary.token.JwtTokenProvider;
import com.anglehack.anywhereLibrary.user.dto.UserInfo;
import com.anglehack.anywhereLibrary.user.entity.User;
import com.anglehack.anywhereLibrary.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/users")
public class UserController {
    @Value("${JWT_SECRET}")
    String secretKey;

    @Value("${JWT_EXPIRATION}")
    int expirationDate;

    private final UserService userService;

    @ApiOperation("회원가입")
    @PostMapping("/user/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public SignInResponse signUp(@RequestBody SignUpRequest signUpRequest){
        User user = userService.signUp(signUpRequest.of());

        return SignInResponse.builder()
                .userInfo(UserInfo.of(user))
                .accessToken(JwtTokenProvider.getInstance().generateAccessKey(user, secretKey, expirationDate))
                .refreshToken(JwtTokenProvider.getInstance().generateRefreshToken(user, secretKey))
                .build();
    }
}
