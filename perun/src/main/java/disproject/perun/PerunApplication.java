package disproject.perun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import disproject.perun.controllers.AppUserController;

@EnableFeignClients
@SpringBootApplication
@ComponentScan(basePackageClasses=AppUserController.class)
public class PerunApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerunApplication.class, args);
	}

}
