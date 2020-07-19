package com.anglehack.anywhereLibrary.domain.auth.service;

import com.anglehack.anywhereLibrary.domain.auth.JwtTokenProvider;
import com.anglehack.anywhereLibrary.domain.user.entity.User;
import com.anglehack.anywhereLibrary.domain.user.exception.UserDoesNotExistException;
import com.anglehack.anywhereLibrary.domain.user.repository.UserRepository;
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

    public User findUserByAccessToken(String accessToken) {
        Long userId = findUserIdByAccessToken(accessToken);

        return userRepository.findById(userId).orElseThrow(UserDoesNotExistException::new);
    }

    public Long findUserIdByAccessToken(String accessToken) {
        Claims claims = JwtTokenProvider.getInstance().decodingToken(accessToken, secretKey);

        return JwtTokenProvider.getInstance().getUserIdByClaims(claims, "AccessToken");
    }
}
