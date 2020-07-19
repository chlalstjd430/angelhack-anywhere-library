package com.anglehack.anywhereLibrary.domain.user.repository;

import com.anglehack.anywhereLibrary.domain.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.domain.user.dto.UniversityRanking;
import com.anglehack.anywhereLibrary.domain.user.entity.UserLearningTime;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserLearningTimeRepository extends ExtendRepository<UserLearningTime> {
    @Query("select u.universityName as universityName, sec_to_time(time_to_sec(sum( ult.learningTime))) as learningTime " +
            "from UserLearningTime ult " +
            "Left join User u " +
            "On u.id = ult.user.id " +
            "Group by u.universityName " +
            "order by learningTime desc")
    Collection<UniversityRanking> getUniversityRank();
}
