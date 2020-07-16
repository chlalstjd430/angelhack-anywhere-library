package com.anglehack.anywhereLibrary.seat.entity;

import com.anglehack.anywhereLibrary.library.entity.Library;
import com.anglehack.anywhereLibrary.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalTime learningTime = LocalTime.of(0, 0);

    private LocalTime restTime = LocalTime.of(0,0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    private Library library;
}
