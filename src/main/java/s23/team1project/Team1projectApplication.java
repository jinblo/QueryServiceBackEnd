package s23.team1project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;

@SpringBootApplication
public class Team1projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team1projectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(QueryRepository queryRepo) {
		return (args) -> {
			queryRepo.save(new Query("test title", "test description"));
		};
	}

}
