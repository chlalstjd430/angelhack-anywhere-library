package com.anglehack.anywhereLibrary.api.library.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLibraryRequest {
    private String name;
    private int totalPersonnel;
    private String hangout;
}
