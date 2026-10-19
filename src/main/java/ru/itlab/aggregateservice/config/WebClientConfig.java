package ru.itlab.aggregateservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.reactive.function.client.WebClient;
import ru.itlab.aggregateservice.config.props.ExternalServiceProps;

@RequiredArgsConstructor
@Configuration
@Profile("!test")
public class WebClientConfig {

    private final ExternalServiceProps props;
    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    @Bean
    public WebClient menuWebClient(WebClient.Builder loadBalancedBuilder) {
        return loadBalancedBuilder
                .filter(lbFunction)
                .baseUrl(props.menuServiceUrl())
                .build();
    }

    @Bean
    public WebClient reviewsWebClient(WebClient.Builder loadBalancedBuilder) {
        return loadBalancedBuilder
                .filter(lbFunction)
                .baseUrl(props.reviewServiceUrl())
                .build();
    }
}
