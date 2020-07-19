package com.anglehack.anywhereLibrary.domain.user.entity;

import com.anglehack.anywhereLibrary.domain.common.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String identification;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String hashedPassword;

    private String universityName = "none";
}