package br.mg.cadastro.gerenciador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CadastroInicialApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroInicialApplication.class, args);
	}
}