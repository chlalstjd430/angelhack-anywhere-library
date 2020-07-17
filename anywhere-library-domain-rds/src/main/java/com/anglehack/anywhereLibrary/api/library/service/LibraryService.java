package com.anglehack.anywhereLibrary.api.library.service;

import com.anglehack.anywhereLibrary.api.library.entity.Library;
import com.anglehack.anywhereLibrary.api.library.exception.LibraryNameDuplicateException;
import com.anglehack.anywhereLibrary.api.library.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Library> findAll(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }
}
