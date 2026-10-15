package ru.itlab.aggregateservice.dto.review;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;

import java.util.List;

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record RatedReviewsList(
    List<Review> reviews,
    MenuRatingInfo menuRating,
    ErrorResponse errorResponse
) {
    public static RatedReviewsList fallbackResponse(Long menuId) {
        return RatedReviewsList.builder()
                .menuRating(MenuRatingInfo.defaultRating(menuId))
                .reviews(List.of())
                .errorResponse(ErrorResponse.builder()
                        .message("Не удалось получить данные об отзывах и рейтинге блюда.")
                        .reason("Микросервис Review Service недоступен.")
                        .build())
                .build();
    }
}
