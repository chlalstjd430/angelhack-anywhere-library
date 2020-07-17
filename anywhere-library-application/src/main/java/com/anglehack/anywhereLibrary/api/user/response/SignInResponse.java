package com.anglehack.anywhereLibrary.api.user.response;

import com.anglehack.anywhereLibrary.api.auth.dto.AccessToken;
import com.anglehack.anywhereLibrary.api.user.dto.SimpleUser;
import lombok.*;

@AllArgsConstructor
@Builder
@Setter
@Getter
public class SignInResponse{
    private SimpleUser simpleUser;
    private AccessToken accessToken;
    private String refreshToken;
}
