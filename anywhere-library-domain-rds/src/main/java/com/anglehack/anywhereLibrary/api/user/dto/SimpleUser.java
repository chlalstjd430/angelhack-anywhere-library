package com.anglehack.anywhereLibrary.api.user.dto;

import com.anglehack.anywhereLibrary.api.user.entity.User;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class SimpleUser {
    private long id;
    private String identification;
    private String nickname;
    private String universityName;

    public static SimpleUser of(User user) {
        return SimpleUser.builder()
                .id(user.getId())
                .identification(user.getIdentification())
                .nickname(user.getNickname())
                .universityName(user.getUniversityName())
                .build();
    }
}
