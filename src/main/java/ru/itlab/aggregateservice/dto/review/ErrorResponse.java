package ru.itlab.aggregateservice.dto.review;

import lombok.Builder;
import lombok.Data;

@Builder
public record ErrorResponse (
    String message,
    String reason
) {
}
