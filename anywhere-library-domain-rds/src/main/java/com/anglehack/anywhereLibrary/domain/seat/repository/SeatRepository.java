package com.anglehack.anywhereLibrary.domain.seat.repository;

import com.anglehack.anywhereLibrary.domain.common.repository.ExtendRepository;
import com.anglehack.anywhereLibrary.domain.seat.entity.Seat;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends ExtendRepository<Seat> {
    boolean existsByUserId(Long userId);

    Optional<Seat> findByIdAndLibraryId(Long seatId, Long libraryId);

    Optional<Seat> findByIdAndLibraryIdAndUserId(Long seatId, Long libraryId, Long userId);

    List<Seat> findAllByLibraryId(Long libraryId);
}