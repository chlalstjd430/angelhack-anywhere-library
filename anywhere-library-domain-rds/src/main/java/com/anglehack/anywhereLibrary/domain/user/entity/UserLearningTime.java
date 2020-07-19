package com.anglehack.anywhereLibrary.domain.user.entity;

import com.anglehack.anywhereLibrary.domain.common.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_learning_times")
public class UserLearningTime extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private LocalTime learningTime;

    @CreatedDate
    private LocalDate learningDate = LocalDate.now();

    @Builder
    public UserLearningTime(User user, LocalTime learningTime) {
        this.user = user;
        this.learningTime = learningTime;
    }
}
