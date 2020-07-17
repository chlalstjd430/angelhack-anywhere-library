package com.anglehack.anywhereLibrary.api.library.response;

import com.anglehack.anywhereLibrary.api.library.dto.SimpleLibrary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class GetLibraryResponse {
    private SimpleLibrary library;
}
