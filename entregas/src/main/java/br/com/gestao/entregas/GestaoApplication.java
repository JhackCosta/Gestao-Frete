package br.com.gestao.entregas;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//console: http://localhost:8080/swagger-ui/index.html#/
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Controle-Fretes", version = "1", description = "API para Gestão de fretes"))
public class GestaoApplication {

	public static void main(String[] args) {
		System.out.println("\n Swagger: http://localhost:8080/swagger-ui/index.html#/ \n");
		SpringApplication.run(GestaoApplication.class, args);
	}

}
