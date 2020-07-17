package com.anglehack.anywhereLibrary.library.request;

import com.anglehack.anywhereLibrary.library.entity.Library;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateLibraryRequest {
    private String name;
    private int totalPersonnel;
    private String hangout;
}
