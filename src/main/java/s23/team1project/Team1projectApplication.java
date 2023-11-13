package s23.team1project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.Question;
import s23.team1project.domain.QuestionRepository;

@SpringBootApplication
public class Team1projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team1projectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(QueryRepository queryRepo, QuestionRepository questionRepo) {
		return (args) -> {
			queryRepo.save(new Query("test title", "test description"));
			queryRepo.save(new Query("query 2", "description 2"));
			queryRepo.save(new Query("query 3", "description 3"));
			questionRepo.save(new Question("test", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question("test2", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question("test", queryRepo.findById((long) 2).get()));
			questionRepo.save(new Question("test2", queryRepo.findById((long) 2).get()));


		};
	}

}
