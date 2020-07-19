package com.anglehack.anywhereLibrary.api.library.response;

import com.anglehack.anywhereLibrary.domain.library.dto.SimpleLibrary;
import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchLibrariesResponse {
    private List<SimpleLibrary> libraries;
    private int currentPage;
    private int totalPage;
    private int totalLibraries;

    @Builder
    public SearchLibrariesResponse(List<SimpleLibrary> libraries, int currentPage, int totalPage, int totalLibraries) {
        this.libraries = libraries;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalLibraries = totalLibraries;
    }
}
