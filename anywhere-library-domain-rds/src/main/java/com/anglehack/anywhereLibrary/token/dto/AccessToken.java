package com.anglehack.anywhereLibrary.token.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccessToken {
    private String token;
    private long expire;
}