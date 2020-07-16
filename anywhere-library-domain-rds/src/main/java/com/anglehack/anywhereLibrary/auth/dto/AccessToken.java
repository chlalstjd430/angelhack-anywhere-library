package com.anglehack.anywhereLibrary.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessToken {
    private String token;
    private long expire;
}