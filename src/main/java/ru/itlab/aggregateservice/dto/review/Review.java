package ru.itlab.aggregateservice.dto.review;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Review(
    Long id,
    Long menuId,
    String createdBy,
    String comment,
    Integer rate,
    LocalDateTime createdAt
) {
}
