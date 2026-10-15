package ru.itlab.aggregateservice.dto.review;

import lombok.Builder;

@Builder
public record MenuRatingInfo(
    Long menuId,
    Float wilsonScore,
    Float avgStars
) {
    public static MenuRatingInfo defaultRating(Long menuId) {
        return MenuRatingInfo.builder()
                .menuId(menuId)
                .wilsonScore(0.0f)
                .avgStars(0.0f)
                .build();
    }
}
