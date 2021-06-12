package disproject.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p->p.path("/app-users/**").uri("lb://perun"))
				.route(p->p.path("/app-user/**").uri("lb://perun"))
				.route(p->p.path("/baskets/**").uri("lb://perun"))
				.route(p->p.path("/basket/**").uri("lb://perun"))
				.route(p->p.path("/stores/**").uri("lb://perun"))
				.route(p->p.path("/store/**").uri("lb://perun"))
				
				.route(p->p.path("/users/**").uri("lb://dabog"))
				.route(p->p.path("/user/**").uri("lb://dabog"))
				.route(p->p.path("/cards/**").uri("lb://dabog"))
				.route(p->p.path("/card/**").uri("lb://dabog"))
				
				.route(p->p.path("/users/**").uri("lb://svarog"))
				.route(p->p.path("/user/**").uri("lb://svarog"))
				.route(p->p.path("/items/**").uri("lb://svarog"))
				.route(p->p.path("/item/**").uri("lb://svarog"))
				.route(p->p.path("/vendors/**").uri("lb://svarog"))
				.route(p->p.path("/vendor/**").uri("lb://svarog"))
				.build();
				
	}
}
