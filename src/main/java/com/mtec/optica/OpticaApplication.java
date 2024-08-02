package com.mtec.optica;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class OpticaApplication {
	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

		// Configurar las propiedades del sistema
		System.setProperty("MYSQLHOST", dotenv.get("MYSQLHOST"));
		System.setProperty("MYSQLPORT", dotenv.get("MYSQLPORT"));
		System.setProperty("MYSQLDATABASE", dotenv.get("MYSQLDATABASE"));
		System.setProperty("MYSQLUSER", dotenv.get("MYSQLUSER"));
		System.setProperty("MYSQLPASSWORD", dotenv.get("MYSQLPASSWORD"));


		SpringApplication.run(OpticaApplication.class, args);
	}


}
