package com.anglehack.anywhereLibrary.api.user.request;

import com.anglehack.anywhereLibrary.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
public class SignUpRequest {
    private String identification;
    private String nickname;
    private String hashedPassword;
    private String universityName = "none";

    public User of() {
        return User.builder()
                .identification(identification)
                .nickname(nickname)
                .hashedPassword(hashedPassword)
                .universityName(universityName)
                .build();
    }
}
