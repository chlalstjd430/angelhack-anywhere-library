package com.anglehack.anywhereLibrary.library.response;

import com.anglehack.anywhereLibrary.library.dto.SimpleLibrary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreateLibraryResponse {
    private SimpleLibrary library;
}
