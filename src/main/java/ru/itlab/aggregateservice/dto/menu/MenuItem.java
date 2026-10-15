package ru.itlab.aggregateservice.dto.menu;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SuperBuilder
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class MenuItem {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private long timeToCook;
    private double weight;
    private String imageUrl;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private IngredientCollection ingredientCollection;
}