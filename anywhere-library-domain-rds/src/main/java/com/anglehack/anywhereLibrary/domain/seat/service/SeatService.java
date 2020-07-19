package com.anglehack.anywhereLibrary.domain.seat.service;

import com.anglehack.anywhereLibrary.domain.library.exception.LibraryDoesNotExistException;
import com.anglehack.anywhereLibrary.domain.seat.dto.SimpleSeat;
import com.anglehack.anywhereLibrary.domain.seat.entity.Seat;
import com.anglehack.anywhereLibrary.domain.seat.exception.AlreadyUserHaveSeatException;
import com.anglehack.anywhereLibrary.domain.seat.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Service
@AllArgsConstructor
@Transactional
public class SeatService {
    private final SeatRepository seatRepository;

    public Seat create(Seat seat) {
        return seatRepository.save(seat);
    }

    public SimpleSeat updateSeatTime(Long libraryId, Long seatId, Long userId, LocalTime learningTime, LocalTime restTime) {
        Seat seat = seatRepository.findByIdAndLibraryIdAndUserId(seatId, libraryId, userId)
                .orElseThrow(LibraryDoesNotExistException::new);
        seat.setLearningTime(learningTime);
        seat.setRestTime(restTime);

        return SimpleSeat.of(seat);
    }

    public void deleteSeat(Long seatId) {
        seatRepository.deleteById(seatId);
    }

    public void checkUserHasSeat(Long userId) {
        if (seatRepository.existsByUserId(userId)) {
            throw new AlreadyUserHaveSeatException();
        }
    }
}
