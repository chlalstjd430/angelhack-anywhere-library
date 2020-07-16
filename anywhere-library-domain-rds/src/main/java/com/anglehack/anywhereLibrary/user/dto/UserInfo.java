package com.anglehack.anywhereLibrary.user.dto;

import com.anglehack.anywhereLibrary.user.entity.User;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class UserInfo {
    private long id;
    private String identification;
    private String nickname;
    private String universityName;
    private int learningHour;
    private int learningMinute;

    public static UserInfo of(User user) {
        return UserInfo.builder()
                .id(user.getId())
                .identification(user.getIdentification())
                .nickname(user.getNickname())
                .universityName(user.getUniversityName())
                .learningHour(user.getLearningHour())
                .learningMinute(user.getLearningMinute())
                .build();
    }
}
