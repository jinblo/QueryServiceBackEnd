package s23.team1project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
	
	//Listing queries
	@GetMapping("/queries")
    public List<Query> findQueries() {	
        return (List<Query>) queryRepo.findAll();
    }
	
	//Find a query by id
	@GetMapping("/queries/{id}")
    public Optional<Query> findQueryById(@PathVariable("id") Long id) {	
        return queryRepo.findById(id);
    }
	
	//Listing questions of specific query by query id
	@GetMapping("/queries/{id}/questions")
    public List<Question> findByQuery(@PathVariable("id") Long queryId) {	
        return (List<Question>) questionRepo.findByQuery(queryRepo.findById(queryId).get());
    }
	
	//Tarvitaanko?
	/*@GetMapping("/queries/{id}/questions/{questionId}")
    public Optional<Question> findQuestionByQuery(@PathVariable("questionId") Long questionId) {	
    	return questionRepo.findById(questionId);
    }*/
	

	
	

}
