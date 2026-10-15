package ru.itlab.aggregateservice.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import ru.itlab.aggregateservice.BaseTest;
import ru.itlab.aggregateservice.dto.aggregate.MenuAggregate;
import ru.itlab.aggregateservice.dto.aggregate.MenuAggregateList;
import ru.itlab.aggregateservice.dto.aggregate.RatedMenuSort;
import ru.itlab.aggregateservice.dto.menu.Category;
import ru.itlab.aggregateservice.dto.review.ReviewSort;
import ru.itlab.aggregateservice.exception.MenuAggregateException;
import ru.itlab.aggregateservice.service.impl.AggregateServiceImpl;

import static ru.itlab.aggregateservice.testutil.TestConstants.MENU_ONE_ID;
import static ru.itlab.aggregateservice.testutil.TestDateProvider.expectedMenuAggregate;
import static ru.itlab.aggregateservice.testutil.TestDateProvider.expectedMenuAggregateWithFallback;

class AggregateServiceImplTest extends BaseTest {

    @Autowired
    private AggregateServiceImpl aggregateService;

    @Test
    void getMenuAggregateInfo_returnsCorrectResponse() {
        stubForCorrectRatedReviewsList();
        stubForCorrectMenuItemResponse();

        StepVerifier.create(getMenuAggregateMono())
                .expectNextMatches(response ->
                        response.equals(expectedMenuAggregate()))
                .verifyComplete();
    }

    @Test
    void getMenuAggregateInfo_returnsErrorWhenMenuServiceUnavailable() {
        stubForCorrectRatedReviewsList();
        stubForMenuItem500Error();

        StepVerifier.create(getMenuAggregateMono())
                .expectError(MenuAggregateException.class)
                .verify();
    }

    @Test
    void getMenuAggregateInfo_returnsFallbackWhenReviewServiceUnavailable() {
        stubForRatedReviewsList500Error();
        stubForCorrectMenuItemResponse();

        StepVerifier.create(getMenuAggregateMono())
                .expectNextMatches(response ->
                        response.equals(expectedMenuAggregateWithFallback()))
                .verifyComplete();
    }

    private Mono<MenuAggregate> getMenuAggregateMono() {
        return aggregateService.getMenuAggregateInfo(MENU_ONE_ID, ReviewSort.DATE_ASC, 0, 10);
    }

    private Mono<MenuAggregateList> getMenuRatingsMono() {
        return aggregateService.getMenusWithRatings(Category.DRINKS, RatedMenuSort.DATE_DESC);
    }
}
