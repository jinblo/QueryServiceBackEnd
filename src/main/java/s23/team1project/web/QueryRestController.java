package s23.team1project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.Question;
import s23.team1project.domain.QuestionRepository;

@CrossOrigin
@RestController
public class QueryRestController {
	
	@Autowired
	private QueryRepository queryRepo;
	
	@Autowired
	private QuestionRepository questionRepo;
	
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
	

	
	

}
