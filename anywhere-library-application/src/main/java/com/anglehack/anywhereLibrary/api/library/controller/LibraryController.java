package com.anglehack.anywhereLibrary.api.library.controller;

import com.anglehack.anywhereLibrary.api.library.response.SearchLibrariesResponse;
import com.anglehack.anywhereLibrary.auth.service.AuthService;
import com.anglehack.anywhereLibrary.api.library.dto.SimpleLibrary;
import com.anglehack.anywhereLibrary.api.library.entity.Library;
import com.anglehack.anywhereLibrary.api.library.request.CreateLibraryRequest;
import com.anglehack.anywhereLibrary.api.library.response.CreateLibraryResponse;
import com.anglehack.anywhereLibrary.api.library.service.LibraryService;
import com.anglehack.anywhereLibrary.user.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/libraries")
public class LibraryController {
    private final LibraryService libraryService;
    private final AuthService authService;

    @ApiOperation("도서관 생성")
    @PostMapping("/library")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateLibraryResponse signUp(
        @RequestHeader String accessToken,
        @RequestBody CreateLibraryRequest createLibraryRequest
    ) {
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

    @ApiOperation("도서관 조회")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SearchLibrariesResponse searchLibraries(
        @RequestParam(required = false, defaultValue = "0")  int currentPage,
        @RequestParam(required = false, defaultValue = "12") int size
    ) {
        List<SimpleLibrary> libraries = new ArrayList<>();
        Page<Library> searchResult = libraryService.findAll(PageRequest.of(currentPage, size, Sort.by("name").descending()));
        searchResult.getContent().forEach(
            library -> {
                if (library != null)
                    libraries.add(SimpleLibrary.of(library));
            }
        );

        return SearchLibrariesResponse.builder()
                .libraries(libraries)
                .currentPage(searchResult.getNumber())
                .totalLibraries(searchResult.getTotalPages())
                .totalPage(searchResult.getTotalPages())
                .build();
    }

}
