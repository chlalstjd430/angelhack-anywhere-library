package com.anglehack.anywhereLibrary.api.seat.response;

import com.anglehack.anywhereLibrary.api.seat.dto.SimpleSeat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ChooseSeatResponse {
    private SimpleSeat seat;
}
