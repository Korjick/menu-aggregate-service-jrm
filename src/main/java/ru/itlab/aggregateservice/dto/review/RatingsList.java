package ru.itlab.aggregateservice.dto.review;

import lombok.Builder;

import java.util.List;

@Builder
public record RatingsList(
    List<MenuRatingInfo> menuRatings
) {
}
