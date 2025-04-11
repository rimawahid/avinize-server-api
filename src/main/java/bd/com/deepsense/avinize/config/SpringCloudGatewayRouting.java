package bd.com.deepsense.avinize.config;


import bd.com.deepsense.avinize.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("avinize-server-super-admin", r->r.path("/*/auth/**").uri("lb://avinize-server-super-admin"))
                .route("avinize-server-super-admin", r->r.path("/*/public/sya/**").uri("lb://avinize-server-super-admin"))
                .route("avinize-server-super-admin", r->r.path("/*/private/sya/**").filters(f -> f.filter(filter)).uri("lb://avinize-server-super-admin"))
                .route("avinize-server-super-admin", r->r.path("/*/public/common/**").uri("lb://avinize-server-super-admin"))
                .route("avinize-server-super-admin", r->r.path("/*/private/common/**").filters(f -> f.filter(filter)).uri("lb://avinize-server-super-admin"))
                .route("fpbs-server-budget", r->r.path("/*/public/budget/**").uri("lb://fpbs-server-budget"))
                .route("fpbs-server-budget", r->r.path("/*/private/budget/**").filters(f -> f.filter(filter)).uri("lb://fpbs-server-budget"))
                .route("fpbs-server-budget", r->r.path("/*/public/other/**").uri("lb://fpbs-server-budget"))
                .route("fpbs-server-budget", r->r.path("/*/private/other/**").filters(f -> f.filter(filter)).uri("lb://fpbs-server-budget"))
            .build();
    }

}
