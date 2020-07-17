package com.anglehack.anywhereLibrary.library.repository;

import com.anglehack.anywhereLibrary.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.library.entity.Library;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends ExtendRepository<Library> {
    boolean existsByName(String name);
}
