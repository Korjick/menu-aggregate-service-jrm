package ru.itlab.aggregateservice.dto.review;

import lombok.Builder;

import java.util.Set;

@Builder
public record GetRatingsRequest(
    Set<Long> menuIds
) {
}
