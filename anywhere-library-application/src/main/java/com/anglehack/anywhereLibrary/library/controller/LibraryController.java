package com.anglehack.anywhereLibrary.library.controller;

import com.anglehack.anywhereLibrary.auth.service.AuthService;
import com.anglehack.anywhereLibrary.library.dto.SimpleLibrary;
import com.anglehack.anywhereLibrary.library.entity.Library;
import com.anglehack.anywhereLibrary.library.request.CreateLibraryRequest;
import com.anglehack.anywhereLibrary.library.response.CreateLibraryResponse;
import com.anglehack.anywhereLibrary.library.service.LibraryService;
import com.anglehack.anywhereLibrary.auth.JwtTokenProvider;
import com.anglehack.anywhereLibrary.user.dto.SimpleUser;
import com.anglehack.anywhereLibrary.user.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/libraries")
public class LibraryController {
    private final LibraryService libraryService;
    private final AuthService authService;

    @ApiOperation("도서관 생성")
    @PostMapping("/library")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateLibraryResponse signUp(
            @RequestHeader String accessToken,
            @RequestBody CreateLibraryRequest createLibraryRequest
    ){
        User user = authService.findUserByAccessToken(accessToken);

        Library library = Library.builder()
                .hangout(createLibraryRequest.getHangout())
                .name(createLibraryRequest.getName())
                .totalPersonnel(createLibraryRequest.getTotalPersonnel())
                .owner(user)
                .seats(new ArrayList<>())
                .build();
        library = libraryService.create(library);

        return new CreateLibraryResponse(SimpleLibrary.of(library));
    }
}
