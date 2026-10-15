package ru.itlab.aggregateservice.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "external")
public record ExternalServiceProps (
    String menuServiceUrl,
    String reviewServiceUrl,
    String menuItemPath,
    String menuReviewsPath,
    String menuRatingsPath,
    Duration defaultTimeout,
    Duration retryBackoff,
    Integer retryCount,
    Double retryJitter
) {
}
