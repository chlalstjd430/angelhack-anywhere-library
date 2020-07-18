package com.anglehack.anywhereLibrary.api.user.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "user_learning_times")
public class UserLearningTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalTime learningTime;

    private LocalDate learningDate;

    public UserLearningTime(User user, LocalTime learningTime) {
        this.user = user;
        this.learningTime = learningTime;
        this.learningDate = LocalDate.now();
    }
}
