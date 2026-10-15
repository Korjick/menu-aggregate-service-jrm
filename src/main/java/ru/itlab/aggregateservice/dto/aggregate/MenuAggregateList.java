package ru.itlab.aggregateservice.dto.aggregate;

import lombok.Builder;

import java.util.List;

@Builder
public record MenuAggregateList(
    List<RatedMenuItem> menuItems
) {
}
