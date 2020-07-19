package com.anglehack.anywhereLibrary.domain.library.repository;

import com.anglehack.anywhereLibrary.domain.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.domain.library.entity.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends ExtendRepository<Library> {
    boolean existsByName(String name);

    Page<Library> findAll(Pageable pageable);

}
