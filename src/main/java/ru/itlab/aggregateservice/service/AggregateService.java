package ru.itlab.aggregateservice.service;

import reactor.core.publisher.Mono;
import ru.itlab.aggregateservice.dto.aggregate.MenuAggregate;
import ru.itlab.aggregateservice.dto.aggregate.MenuAggregateList;
import ru.itlab.aggregateservice.dto.aggregate.RatedMenuSort;
import ru.itlab.aggregateservice.dto.menu.Category;
import ru.itlab.aggregateservice.dto.review.ReviewSort;

public interface AggregateService {
    Mono<MenuAggregate> getMenuAggregateInfo(Long menuId, ReviewSort sort, int from, int size);
    Mono<MenuAggregateList> getMenusWithRatings(Category category, RatedMenuSort sort);
}
