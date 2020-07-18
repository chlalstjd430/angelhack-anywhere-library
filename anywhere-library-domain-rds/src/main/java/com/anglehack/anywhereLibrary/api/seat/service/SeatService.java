package com.anglehack.anywhereLibrary.api.seat.service;

import com.anglehack.anywhereLibrary.api.library.exception.LibraryDoesNotExistException;
import com.anglehack.anywhereLibrary.api.seat.dto.SimpleSeat;
import com.anglehack.anywhereLibrary.api.seat.entity.Seat;
import com.anglehack.anywhereLibrary.api.seat.exception.AlreadyUserHaveSeatException;
import com.anglehack.anywhereLibrary.api.seat.exception.SeatDoesNotExistException;
import com.anglehack.anywhereLibrary.api.seat.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
