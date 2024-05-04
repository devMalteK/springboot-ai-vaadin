package de.kochnetonline.springbootaivaadin;

import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootAiVaadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAiVaadinApplication.class, args);
	}

}
