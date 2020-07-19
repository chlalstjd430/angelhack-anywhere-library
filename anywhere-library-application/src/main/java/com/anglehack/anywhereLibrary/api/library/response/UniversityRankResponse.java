package com.anglehack.anywhereLibrary.api.library.response;

import com.anglehack.anywhereLibrary.domain.user.dto.UniversityRanking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@Setter
@Getter
public class UniversityRankResponse {
    private Collection<UniversityRanking> ranks;
}
