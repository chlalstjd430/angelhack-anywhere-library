package com.anglehack.anywhereLibrary.api.test.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/api/test")
public class TestController {
    @ApiOperation("test")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String signUp(@RequestBody String test){
        return test + " 완료";
    }
}
