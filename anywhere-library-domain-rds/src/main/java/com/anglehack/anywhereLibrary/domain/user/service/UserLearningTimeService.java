package com.anglehack.anywhereLibrary.domain.user.service;

import com.anglehack.anywhereLibrary.domain.user.dto.UniversityRanking;
import com.anglehack.anywhereLibrary.domain.user.entity.UserLearningTime;
import com.anglehack.anywhereLibrary.domain.user.repository.UserLearningTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLearningTimeService {
    private final UserLearningTimeRepository userLearningTimeRepository;

    public UserLearningTime create(UserLearningTime userLearningTime) {
        return userLearningTimeRepository.save(userLearningTime);
    }

    public Collection<UniversityRanking> getUniversityRank() {
        return userLearningTimeRepository.getUniversityRank();
    }
}
