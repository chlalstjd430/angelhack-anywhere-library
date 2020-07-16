package com.anglehack.anywhereLibrary.auth.service;

import com.anglehack.anywhereLibrary.auth.JwtTokenProvider;
import com.anglehack.anywhereLibrary.user.entity.User;
import com.anglehack.anywhereLibrary.user.exception.UserDoesNotExistException;
import com.anglehack.anywhereLibrary.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    @Value("${JWT_SECRET}")
    private String secretKey;

    @Value("${JWT_EXPIRATION}")
    private int expirationDate;

    private final UserRepository userRepository;


    public User findUserByAccessToken(String accessToken){
        Claims claims = JwtTokenProvider.getInstance().decodingToken(accessToken, secretKey);
        Long userId = JwtTokenProvider.getInstance().getUserIdByClaims(claims, "AccessToken");

        return userRepository.findById(userId).orElseThrow(UserDoesNotExistException::new);
    }
}
