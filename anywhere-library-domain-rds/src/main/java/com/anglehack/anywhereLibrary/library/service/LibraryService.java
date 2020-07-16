package com.anglehack.anywhereLibrary.library.service;

import com.anglehack.anywhereLibrary.library.entity.Library;
import com.anglehack.anywhereLibrary.library.exception.LibraryNameDuplicateException;
import com.anglehack.anywhereLibrary.library.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public Library create(Library library) {
        checkDuplicateLibraryName(library.getName());

        return libraryRepository.save(library);
    }

    public void checkDuplicateLibraryName(String name) {
        if (libraryRepository.existsByName(name))
            throw new LibraryNameDuplicateException();
    }
}
