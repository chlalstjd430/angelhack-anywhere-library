package com.anglehack.anywhereLibrary.api.test.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/test")
public class TestController {

    @ApiOperation(value = "테스트")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String test(){
        return "테스트 성공";
    }
}
