package com.anglehack.anywhereLibrary.api.library.repository;

import com.anglehack.anywhereLibrary.api.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.api.library.entity.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends ExtendRepository<Library> {
    boolean existsByName(String name);

    Page<Library> findAll(Pageable pageable);
}
