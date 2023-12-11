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
			answerOptionRepo.save(new AnswerOption("vastausvaihtoehto1", questionRepo.findById((long) 1).get()));
			answerOptionRepo.save(new AnswerOption("vastausvaihtoehto2", questionRepo.findById((long) 1).get()));
			answerOptionRepo.save(new AnswerOption("Erittäin tyytyväinen", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Melko tyytyväinen", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("En osaa sanoa", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Melko tyytymätön", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Erittäin tyytymätön", questionRepo.findById((long) 3).get()));
			answerOptionRepo.save(new AnswerOption("Kiitettävä (5)", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("Erittäin hyvä (4)", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("Hyvä (3)", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("Tyydyttävä (2)", questionRepo.findById((long) 5).get()));
			answerOptionRepo.save(new AnswerOption("Välttävä (1)", questionRepo.findById((long) 5).get()));
			answerRepo.save(new Answer("Ihan hyvä", questionRepo.findById((long) 1).get()));
			answerRepo.save(new Answer("Kaikki meni pieleen", questionRepo.findById((long) 1).get()));
			answerRepo.save(new Answer("En ymmärrä kysymystä", questionRepo.findById((long) 1).get()));
			answerRepo.save(new Answer("Opin todella paljon ja kaikki oli niin ihanaa", questionRepo.findById((long) 1).get()));
			answerRepo.save(new Answer("Oma-aloitteisuuteni", questionRepo.findById((long) 2).get()));
			answerRepo.save(new Answer("Mikään ei edistänyt", questionRepo.findById((long) 2).get()));
			answerRepo.save(new Answer("Höh", questionRepo.findById((long) 2).get()));
			answerRepo.save(new Answer("Ennen kaikkea oma asenteeni ratkaisi", questionRepo.findById((long) 2).get()));
			answerRepo.save(new Answer("Melko tyytyväinen", questionRepo.findById((long) 3).get()));
			answerRepo.save(new Answer("Erittäin tyytymätön", questionRepo.findById((long) 3).get()));
			answerRepo.save(new Answer("En osaa sanoa", questionRepo.findById((long) 3).get()));
			answerRepo.save(new Answer("Erittäin tyytyväinen", questionRepo.findById((long) 3).get()));
			answerRepo.save(new Answer("En tiedä", questionRepo.findById((long) 4).get()));
			answerRepo.save(new Answer("Ihan sama", questionRepo.findById((long) 4).get()));
			answerRepo.save(new Answer("En ymmärrä kysymystä", questionRepo.findById((long) 4).get()));
			answerRepo.save(new Answer("Opintokokonaisuus oli mielestäni erittäin toimiva, joten en muuttaisi toteutuksessa mitään", questionRepo.findById((long) 4).get()));
			answerRepo.save(new Answer("Hyvä (3)", questionRepo.findById((long) 5).get()));
			answerRepo.save(new Answer("Välttävä (1)", questionRepo.findById((long) 5).get()));
			answerRepo.save(new Answer("Hyvä (3)", questionRepo.findById((long) 5).get()));
			answerRepo.save(new Answer("Kiitettävä (5)", questionRepo.findById((long) 5).get()));
			answerRepo.save(new Answer("Haluan", questionRepo.findById((long) 6).get()));
			answerRepo.save(new Answer("En todellakaan", questionRepo.findById((long) 6).get()));
			answerRepo.save(new Answer("Mitä muuta", questionRepo.findById((long) 6).get()));
			answerRepo.save(new Answer("Aivan ihanaa oli kaikki", questionRepo.findById((long) 6).get()));

		};
	}

}
