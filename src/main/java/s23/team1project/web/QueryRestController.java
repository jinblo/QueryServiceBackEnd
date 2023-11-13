package s23.team1project.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s23.team1project.domain.Answer;
import s23.team1project.domain.AnswerDTO;
import s23.team1project.domain.AnswerRepository;
import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.Question;
import s23.team1project.domain.QuestionRepository;

@RestController
public class QueryRestController {
	
	@Autowired
	private QueryRepository queryRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private AnswerRepository answerRepo;
	
	//Listing all queries
	@GetMapping("/queries")
	public List<Query> findQueries() {	
        return (List<Query>) queryRepo.findAll();
    }
	
	//Show a query by query id
	@GetMapping("/queries/{queryId}")
	public Optional<Query> findQueryById(@PathVariable("queryId") Long queryId) {	
        return queryRepo.findById(queryId);
    }
	
	//Listing questions of a specific query by query id
	@GetMapping("/queries/{queryId}/questions")
	public List<Question> findByQuery(@PathVariable("queryId") Long queryId) {	
        return (List<Question>) questionRepo.findByQuery(queryRepo.findById(queryId).get());
    }
	
	//Tarvitaanko?
	/*@GetMapping("/queries/{queryId}/questions/{questionId}")
	public Optional<Question> findQuestionByQuery(@PathVariable("questionId") Long questionId) {	
    	return questionRepo.findById(questionId);
    }*/
	
	//Saving a single answer to answerRepository
	/*@PostMapping("/queries/{queryId}/answers")
	public Answer saveAnswer(@RequestBody AnswerDTO answerDto) {
		Answer answer = new Answer();
		Question question = questionRepo.findById(answerDto.getQuestionId()).get();
		answer.setAnswerText(answerDto.getText());
		answer.setQuestion(question);
		return answerRepo.save(answer);
	}*/
	
	//Saving answers to answerRepository
	@PostMapping("/queries/{queryId}/answers")
	public Iterable<Answer> saveAnswer(@RequestBody ArrayList<AnswerDTO> response) {
		for (AnswerDTO answerDto : response) {
			Answer answer = new Answer();
			Question question = questionRepo.findById(answerDto.getQuestionId()).get();
			answer.setAnswerText(answerDto.getText());
			answer.setQuestion(question);
			answerRepo.save(answer);
		}
		return answerRepo.findAll();
	}
	

	
	

}
