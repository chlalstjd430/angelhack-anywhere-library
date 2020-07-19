package com.anglehack.anywhereLibrary.domain.seat.entity;

import com.anglehack.anywhereLibrary.domain.common.entity.BaseTimeEntity;
import com.anglehack.anywhereLibrary.domain.library.entity.Library;
import com.anglehack.anywhereLibrary.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "seats")
public class Seat extends BaseTimeEntity {
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

    @Builder
    public Seat(User user, Library library){
        this.user = user;
        this.library = library;
    }
}
