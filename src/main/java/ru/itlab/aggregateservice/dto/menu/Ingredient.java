package ru.itlab.aggregateservice.dto.menu;

import lombok.Builder;

@Builder
public record Ingredient(String name, int calories) {
}

