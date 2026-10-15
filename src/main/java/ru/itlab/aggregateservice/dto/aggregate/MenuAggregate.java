package ru.itlab.aggregateservice.dto.aggregate;

import lombok.Builder;
import ru.itlab.aggregateservice.dto.menu.MenuItem;
import ru.itlab.aggregateservice.dto.review.ErrorResponse;
import ru.itlab.aggregateservice.dto.review.MenuRatingInfo;
import ru.itlab.aggregateservice.dto.review.Review;

import java.util.List;

@Builder
public record MenuAggregate(
    MenuItem menuItem,
    List<Review> reviews,
    MenuRatingInfo ratingInfo,
    ErrorResponse errorResponse
) {
}
