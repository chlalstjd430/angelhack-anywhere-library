package com.anglehack.anywhereLibrary.domain.library.service;

import com.anglehack.anywhereLibrary.domain.library.entity.Library;
import com.anglehack.anywhereLibrary.domain.library.exception.LibraryDoesNotExistException;
import com.anglehack.anywhereLibrary.domain.library.exception.LibraryNameDuplicateException;
import com.anglehack.anywhereLibrary.domain.library.repository.LibraryRepository;
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

    public Library getLibrary(Long libraryId) {
        return libraryRepository.findById(libraryId).orElseThrow(LibraryDoesNotExistException::new);
    }
}
