package ru.itlab.aggregateservice.testutil;

import ru.itlab.aggregateservice.dto.aggregate.MenuAggregate;
import ru.itlab.aggregateservice.dto.aggregate.MenuAggregateList;
import ru.itlab.aggregateservice.dto.aggregate.RatedMenuItem;
import ru.itlab.aggregateservice.dto.menu.Ingredient;
import ru.itlab.aggregateservice.dto.menu.IngredientCollection;
import ru.itlab.aggregateservice.dto.menu.MenuItem;
import ru.itlab.aggregateservice.dto.review.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static ru.itlab.aggregateservice.testutil.TestConstants.*;

public class TestDateProvider {

    public static RatedReviewsList ratedReviewsList() {
        return RatedReviewsList.builder()
                .reviews(List.of(
                        alexReview(),
                        johnReview(),
                        michaelReview(),
                        maxReview(),
                        phillReview()
                ))
                .menuRating(menuOneRatingInfo())
                .build();
    }

    public static Review alexReview() {
        return Review.builder()
                .id(1L)
                .menuId(MENU_ONE_ID)
                .createdBy(ALEX)
                .comment("Comment")
                .rate(ALEX_RATE)
                .createdAt(ALEX_REVIEW_DATE)
                .build();
    }

    public static Review johnReview() {
        return Review.builder()
                .id(7L)
                .menuId(MENU_ONE_ID)
                .createdBy(JOHN)
                .comment("Comment")
                .rate(JOHN_RATE)
                .createdAt(JOHN_REVIEW_DATE)
                .build();
    }

    public static Review michaelReview() {
        return Review.builder()
                .id(8L)
                .menuId(MENU_ONE_ID)
                .createdBy(MICHAEL)
                .comment("Comment")
                .rate(MICHAEL_RATE)
                .createdAt(MICHAEL_REVIEW_DATE)
                .build();
    }

    public static Review maxReview() {
        return Review.builder()
                .id(9L)
                .menuId(MENU_ONE_ID)
                .createdBy(MAX)
                .comment("Comment")
                .rate(MAX_RATE)
                .createdAt(MAX_REVIEW_DATE)
                .build();
    }

    public static Review phillReview() {
        return Review.builder()
                .id(10L)
                .menuId(MENU_ONE_ID)
                .createdBy(PHILL)
                .comment("Comment")
                .rate(PHILL_RATE)
                .createdAt(PHILL_REVIEW_DATE)
                .build();
    }

    public static RatingsList ratingsList() {
        return RatingsList.builder()
                .menuRatings(List.of(menuOneRatingInfo(), menuTwoRatingInfo(), menuThreeRatingInfo()))
                .build();
    }

    public static MenuRatingInfo menuOneRatingInfo() {
        return MenuRatingInfo.builder()
                .menuId(MENU_ONE_ID)
                .wilsonScore(MENU_ONE_WILSON_SCORE)
                .avgStars(MENU_ONE_AVG_STARS)
                .build();
    }

    public static MenuRatingInfo menuTwoRatingInfo() {
        return MenuRatingInfo.builder()
                .menuId(MENU_TWO_ID)
                .wilsonScore(MENU_TWO_WILSON_SCORE)
                .avgStars(MENU_TWO_AVG_STARS)
                .build();
    }

    public static MenuRatingInfo menuThreeRatingInfo() {
        return MenuRatingInfo.builder()
                .menuId(MENU_THREE_ID)
                .wilsonScore(MENU_THREE_WILSON_SCORE)
                .avgStars(MENU_THREE_AVG_STARS)
                .build();
    }

    public static List<MenuItem> drinksMenuList() {
        return List.of(
                menuThreeItem(),
                menuTwoItem(),
                menuOneItem()
        );
    }

    public static MenuItem menuOneItem() {
        var builder = MenuItem.builder();
        builder.id(MENU_ONE_ID);
        builder.name(MENU_ONE_NAME);
        builder.description(MENU_ONE_DESCRIPTION);
        builder.price(MENU_ONE_PRICE);
        builder.category(MENU_ONE_CATEGORY);
        builder.timeToCook(MENU_ONE_TIME_TO_COOK);
        builder.weight(MENU_ONE_WEIGHT);
        builder.imageUrl(MENU_ONE_IMAGE_URL);
        builder.updatedAt(MENU_ONE_UPDATED_AT);
        builder.createdAt(MENU_ONE_CREATED_AT);
        builder.ingredientCollection(ingredientCollection());
        return builder.build();
    }

    public static MenuItem menuTwoItem() {
        var builder = MenuItem.builder();
        builder.id(MENU_TWO_ID);
        builder.name(MENU_TWO_NAME);
        builder.description(MENU_TWO_DESCRIPTION);
        builder.price(MENU_TWO_PRICE);
        builder.category(MENU_TWO_CATEGORY);
        builder.timeToCook(MENU_TWO_TIME_TO_COOK);
        builder.weight(MENU_TWO_WEIGHT);
        builder.imageUrl(MENU_TWO_IMAGE_URL);
        builder.updatedAt(MENU_TWO_UPDATED_AT);
        builder.createdAt(MENU_TWO_CREATED_AT);
        builder.ingredientCollection(ingredientCollection());
        return builder.build();
    }

    public static MenuItem menuThreeItem() {
        var builder = MenuItem.builder();
        builder.id(MENU_THREE_ID);
        builder.name(MENU_THREE_NAME);
        builder.description(MENU_THREE_DESCRIPTION);
        builder.price(MENU_THREE_PRICE);
        builder.category(MENU_THREE_CATEGORY);
        builder.timeToCook(MENU_THREE_TIME_TO_COOK);
        builder.weight(MENU_THREE_WEIGHT);
        builder.imageUrl(MENU_THREE_IMAGE_URL);
        builder.updatedAt(MENU_THREE_UPDATED_AT);
        builder.createdAt(MENU_THREE_CREATED_AT);
        builder.ingredientCollection(ingredientCollection());
        return builder.build();
    }

    public static RatedMenuItem menuOneRatedItem() {
        return RatedMenuItem.builder()
                .id(MENU_ONE_ID)
                .name(MENU_ONE_NAME)
                .description(MENU_ONE_DESCRIPTION)
                .price(MENU_ONE_PRICE)
                .category(MENU_ONE_CATEGORY)
                .timeToCook(MENU_ONE_TIME_TO_COOK)
                .weight(MENU_ONE_WEIGHT)
                .imageUrl(MENU_ONE_IMAGE_URL)
                .updatedAt(MENU_ONE_UPDATED_AT)
                .createdAt(MENU_ONE_CREATED_AT)
                .ingredientCollection(ingredientCollection())
                .wilsonScore(MENU_ONE_WILSON_SCORE)
                .avgStars(MENU_ONE_AVG_STARS)
                .build();
    }

    public static RatedMenuItem menuTwoRatedItem() {
        return RatedMenuItem.builder()
                .id(MENU_TWO_ID)
                .name(MENU_TWO_NAME)
                .description(MENU_TWO_DESCRIPTION)
                .price(MENU_TWO_PRICE)
                .category(MENU_TWO_CATEGORY)
                .timeToCook(MENU_TWO_TIME_TO_COOK)
                .weight(MENU_TWO_WEIGHT)
                .imageUrl(MENU_TWO_IMAGE_URL)
                .updatedAt(MENU_TWO_UPDATED_AT)
                .createdAt(MENU_TWO_CREATED_AT)
                .ingredientCollection(ingredientCollection())
                .wilsonScore(MENU_TWO_WILSON_SCORE)
                .avgStars(MENU_TWO_AVG_STARS)
                .build();
    }

    public static RatedMenuItem menuThreeRatedItem() {
        return RatedMenuItem.builder()
                .id(MENU_THREE_ID)
                .name(MENU_THREE_NAME)
                .description(MENU_THREE_DESCRIPTION)
                .price(MENU_THREE_PRICE)
                .category(MENU_THREE_CATEGORY)
                .timeToCook(MENU_THREE_TIME_TO_COOK)
                .weight(MENU_THREE_WEIGHT)
                .imageUrl(MENU_THREE_IMAGE_URL)
                .updatedAt(MENU_THREE_UPDATED_AT)
                .createdAt(MENU_THREE_CREATED_AT)
                .ingredientCollection(ingredientCollection())
                .wilsonScore(MENU_THREE_WILSON_SCORE)
                .avgStars(MENU_THREE_AVG_STARS)
                .build();
    }

    public static IngredientCollection ingredientCollection() {
        return new IngredientCollection(
                List.of(
                        Ingredient.builder().name(INGREDIENT_ONE_NAME).calories(INGREDIENT_ONE_CALORIES).build(),
                        Ingredient.builder().name(INGREDIENT_TWO_NAME).calories(INGREDIENT_TWO_CALORIES).build()
                )
        );
    }

    public static MenuAggregate expectedMenuAggregate() {
        return MenuAggregate.builder()
                .menuItem(menuOneItem())
                .reviews(List.of(alexReview(), johnReview(), michaelReview(), maxReview(), phillReview()))
                .ratingInfo(menuOneRatingInfo())
                .build();
    }

    public static MenuAggregate expectedMenuAggregateWithFallback() {
        RatedReviewsList fallback = RatedReviewsList.fallbackResponse(MENU_ONE_ID);
        return MenuAggregate.builder()
                .menuItem(menuOneItem())
                .reviews(fallback.reviews())
                .ratingInfo(fallback.menuRating())
                .errorResponse(fallback.errorResponse())
                .build();
    }

    public static MenuAggregateList expectedMenuAggregateList(Comparator<RatedMenuItem> comparator) {
        var list = new ArrayList<RatedMenuItem>();
        list.add(menuOneRatedItem());
        list.add(menuTwoRatedItem());
        list.add(menuThreeRatedItem());
        list.sort(comparator);
        return MenuAggregateList.builder()
                .menuItems(list)
                .build();
    }

    public static GetRatingsRequest getRatingsRequest() {
        return GetRatingsRequest.builder()
                .menuIds(Set.of(MENU_ONE_ID, MENU_TWO_ID, MENU_THREE_ID))
                .build();
    }
}
