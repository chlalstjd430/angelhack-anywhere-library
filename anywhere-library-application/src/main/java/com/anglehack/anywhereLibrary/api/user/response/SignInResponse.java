package com.anglehack.anywhereLibrary.api.user.response;

import com.anglehack.anywhereLibrary.token.dto.AccessToken;
import com.anglehack.anywhereLibrary.user.dto.UserInfo;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class SignInResponse{
    private UserInfo userInfo;
    private AccessToken accessToken;
    private String refreshToken;
}
