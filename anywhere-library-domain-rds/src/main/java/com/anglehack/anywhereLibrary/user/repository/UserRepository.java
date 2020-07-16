package com.anglehack.anywhereLibrary.user.repository;

import com.anglehack.anywhereLibrary.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends ExtendRepository<User> {
    boolean existsByIdentification(String identification);

    boolean existsByNickname(String nickname);

    boolean existsById(long userId);

    Optional<User> findByIdentification(String identification);
}
