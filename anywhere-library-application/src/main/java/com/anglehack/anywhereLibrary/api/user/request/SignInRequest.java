package com.anglehack.anywhereLibrary.api.user.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignInRequest {
    private String identification;
    private String password;
}
