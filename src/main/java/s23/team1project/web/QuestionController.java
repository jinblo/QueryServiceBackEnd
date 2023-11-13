package s23.team1project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.Question;
import s23.team1project.domain.QuestionRepository;

@Controller
public class QuestionController {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private QueryRepository queryRepo;
	
	@GetMapping("query/{id}/listquestions")
	public String showQuestions(@PathVariable("id") Long queryId, Model model) {
		model.addAttribute("questions", questionRepo.findByQuery(queryRepo.findById(queryId).get()));
		return "listquestions";
	}

	// Question adding
	@GetMapping("query/{id}/addquestion")
	public String addQuestion(@PathVariable("id") Long queryId, Model model) {
		model.addAttribute("query", queryRepo.findById(queryId).get());
		model.addAttribute("question", new Question());
		return "addquestion";
	}

	// Question saving
	@PostMapping("query/{id}/savequestion")
	public String saveQuestion(@PathVariable("id") Long queryId, Question question) {
		Query query = queryRepo.findById(queryId).get();
		question.setQuery(query);
		questionRepo.save(question);
		return "redirect:../{id}/listquestions";
	}
	
	// Question deleting
	@GetMapping("query/{id}/deletequestion/{questionId}")
	public String deleteQuestion(@PathVariable("questionId") Long questionId) {
		questionRepo.deleteById(questionId);
		return "redirect:../listquestions";
	}

}
