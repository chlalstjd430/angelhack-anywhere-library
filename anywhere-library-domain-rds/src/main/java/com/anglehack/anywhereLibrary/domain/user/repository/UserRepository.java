package com.anglehack.anywhereLibrary.domain.user.repository;

import com.anglehack.anywhereLibrary.domain.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.domain.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendRepository<User> {
    boolean existsByIdentification(String identification);

    boolean existsByNickname(String nickname);

    boolean existsById(long userId);

    Optional<User> findByIdentification(String identification);
}
