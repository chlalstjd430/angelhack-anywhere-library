package com.anglehack.anywhereLibrary.api.seat.controller;

import com.anglehack.anywhereLibrary.api.auth.service.AuthService;
import com.anglehack.anywhereLibrary.api.library.entity.Library;
import com.anglehack.anywhereLibrary.api.library.service.LibraryService;
import com.anglehack.anywhereLibrary.api.seat.dto.SimpleSeat;
import com.anglehack.anywhereLibrary.api.seat.entity.Seat;
import com.anglehack.anywhereLibrary.api.seat.exception.ExceedSeatException;
import com.anglehack.anywhereLibrary.api.seat.request.UpdateSeatTimeRequest;
import com.anglehack.anywhereLibrary.api.seat.response.ChooseSeatResponse;
import com.anglehack.anywhereLibrary.api.seat.service.SeatService;
import com.anglehack.anywhereLibrary.api.user.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/libraries")
public class SeatController {
    private final LibraryService libraryService;
    private final SeatService seatService;
    private final AuthService authService;

    @ApiOperation("도서관 좌석 선택")
    @PostMapping("/{libraryId}/seats/seat")
    @ResponseStatus(HttpStatus.CREATED)
    public ChooseSeatResponse chooseSeat(
        @RequestHeader String accessToken,
        @PathVariable Long libraryId
    ) {
        User user = authService.findUserByAccessToken(accessToken);

        Library library = libraryService.getLibrary(libraryId);
        if (library.getTotalPersonnel() == library.getSeats().size()) {
            throw new ExceedSeatException();
        }

        seatService.checkUserHasSeat(user.getId());

        SimpleSeat seat = SimpleSeat.of(
            seatService.create(
                Seat.builder()
                    .library(library)
                    .user(user)
                    .build()
            )
        );

        return new ChooseSeatResponse(seat);
    }

    @ApiOperation("도서관 좌석 시간 업데이트")
    @PatchMapping("/{libraryId}/seats/{seatId}")
    @ResponseStatus(HttpStatus.OK)
    public ChooseSeatResponse updateSeatTime(
        @PathVariable Long libraryId,
        @PathVariable Long seatId,
        @RequestBody UpdateSeatTimeRequest updateSeatTimeRequest
    ) {
        SimpleSeat seat =  seatService.updateSeatTime(
            libraryId, seatId, updateSeatTimeRequest.getLearningTime(), updateSeatTimeRequest.getRestTime()
        );

        return new ChooseSeatResponse(seat);
    }
}
