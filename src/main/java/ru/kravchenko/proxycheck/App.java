package ru.kravchenko.proxycheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.kravchenko.proxycheck.api.IBootstrapService;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		IBootstrapService bootstrapService = SpringApplication.run(App.class, args).getBean(IBootstrapService.class);
		bootstrapService.init();
	}

}
