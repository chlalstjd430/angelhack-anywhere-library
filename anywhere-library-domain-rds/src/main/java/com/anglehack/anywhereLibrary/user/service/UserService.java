package com.anglehack.anywhereLibrary.user.service;

import com.anglehack.anywhereLibrary.token.SHA256Util;
import com.anglehack.anywhereLibrary.user.entity.User;
import com.anglehack.anywhereLibrary.user.exception.PasswordDoesNotMatchException;
import com.anglehack.anywhereLibrary.user.exception.UserDoesNotExistException;
import com.anglehack.anywhereLibrary.user.exception.UserIdentificationDuplicateException;
import com.anglehack.anywhereLibrary.user.exception.UserNicknameDuplicateException;
import com.anglehack.anywhereLibrary.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public User signUp(User user) {
        checkDuplicateUserIdentification(user.getIdentification());
        checkDuplicateUserNickname(user.getNickname());
        user.setHashedPassword(SHA256Util.of(user.getHashedPassword()));
        return userRepository.save(user);
    }

    public void checkDuplicateUserIdentification(String identification) {
        if (userRepository.existsByIdentification(identification))
            throw new UserIdentificationDuplicateException();
    }

    public void checkDuplicateUserNickname(String nickname) {
        if (userRepository.existsByNickname(nickname))
            throw new UserNicknameDuplicateException();
    }

    public User signIn(String identification, String password) {
        User user = userRepository.findByIdentification(identification)
                .orElseThrow(UserDoesNotExistException::new);
        String hashedPassword = SHA256Util.of(password);
        if (!user.getHashedPassword().equals(hashedPassword))
            throw new PasswordDoesNotMatchException();

        return user;
    }
}
