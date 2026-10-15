package ru.itlab.aggregateservice.dto.menu;

import lombok.Builder;

import java.util.List;

@Builder
public record IngredientCollection(List<Ingredient> ingredients) {
}
