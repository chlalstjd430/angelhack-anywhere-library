package com.anglehack.anywhereLibrary.api.user.service;

import com.anglehack.anywhereLibrary.api.user.entity.UserLearningTime;
import com.anglehack.anywhereLibrary.api.user.repository.UserLearningTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLearningTimeService {
    private final UserLearningTimeRepository userLearningTimeRepository;

    public UserLearningTime create(UserLearningTime userLearningTime) {
        return userLearningTimeRepository.save(userLearningTime);
    }
}
