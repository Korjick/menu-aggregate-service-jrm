package ru.itlab.aggregateservice.dto.aggregate;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itlab.aggregateservice.dto.menu.MenuItem;

@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class RatedMenuItem extends MenuItem {
    private Float wilsonScore;
    private Float avgStars;
}
