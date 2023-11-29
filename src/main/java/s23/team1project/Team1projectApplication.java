package s23.team1project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s23.team1project.domain.Answer;
import s23.team1project.domain.AnswerOption;
import s23.team1project.domain.AnswerOptionRepository;
import s23.team1project.domain.AnswerRepository;
import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.Question;
import s23.team1project.domain.QuestionRepository;
import s23.team1project.domain.Type;

@SpringBootApplication
public class Team1projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Team1projectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demoData(QueryRepository queryRepo, QuestionRepository questionRepo, AnswerRepository answerRepo, AnswerOptionRepository answerOptionRepo) {
		return (args) -> {
			queryRepo.save(new Query("Opintojaksopalaute", "Anna palautetta opintojaksosta"));
			queryRepo.save(new Query("query 2", "description 2"));
			queryRepo.save(new Query("query 3", "description 3"));
			questionRepo.save(new Question(Type.TEXT, "Miten arvioisit oman oppimisen toteutumista?", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question(Type.TEXT, "Mitkä asiat edistivät oppimistasi?", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question(Type.RADIOBUTTON, "Miten tyytyväinen olet saamaasi ohjaukseen?", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question(Type.TEXT, "Miten kehittäisit toteutusta, jotta osaamistavoitteet saavutettaisiin paremmin?", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question(Type.RADIOBUTTON, "Minkä arvosanan antaisit toteutukselle?", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question(Type.TEXT, "Haluatko antaa muuta palautetta toteutuksesta?", queryRepo.findById((long) 1).get()));
			questionRepo.save(new Question(Type.RADIOBUTTON, "testikysymys1", queryRepo.findById((long) 2).get()));
			questionRepo.save(new Question(Type.TEXT, "testikysymys2", queryRepo.findById((long) 2).get()));
			//answerRepo.save(new Answer("vastaus", questionRepo.findById((long) 2).get()));
			answerOptionRepo.save(new AnswerOption("vastausvaihtoehto1", questionRepo.findById((long) 1).get()));
			answerOptionRepo.save(new AnswerOption("vastausvaihtoehto2", questionRepo.findById((long) 1).get()));
			answerOptionRepo.save(new AnswerOption("Erittäin tyytyväinen", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Melko tyytyväinen", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("En osaa sanoa", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Melko tyytymätön", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Erittäin tyytymätön", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("1", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("2", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("3", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("4", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("5", questionRepo.findById((long) 5).get()));

		};
	}

}
