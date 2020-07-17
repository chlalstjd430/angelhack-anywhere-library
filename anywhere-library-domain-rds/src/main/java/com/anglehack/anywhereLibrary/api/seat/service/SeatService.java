package com.anglehack.anywhereLibrary.api.seat.service;

import com.anglehack.anywhereLibrary.api.seat.dto.SimpleSeat;
import com.anglehack.anywhereLibrary.api.seat.entity.Seat;
import com.anglehack.anywhereLibrary.api.seat.exception.AlreadyUserHaveSeatException;
import com.anglehack.anywhereLibrary.api.seat.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<SimpleSeat> getSeatsByLibrary(Long libraryId) {
        List<SimpleSeat> seats = new ArrayList<>();
        seatRepository.findAllByLibraryId(libraryId).forEach(
                seat -> {
                    if (seat != null)
                        seats.add(SimpleSeat.of(seat));
                }
        );

        return seats;
    }

    public void checkUserHasSeat(Long userId) {
        if (seatRepository.existsByUserId(userId)) {
            throw new AlreadyUserHaveSeatException();
        }
    }
}
