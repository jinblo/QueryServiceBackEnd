package s23.team1project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// Question adding
	@GetMapping("query/{id}/addquestion")
	public String addQuestion(Model model) {
		model.addAttribute("question", new Question());
		return "addquestion";
	}

	// Question saving
	@PostMapping("query/{id}/savequestion")
	public String saveQuestion(@PathVariable("id") Long queryId, Question question) {
		Query query = queryRepo.findById(queryId).get();
		question.setQuery(query);
		questionRepo.save(question);
		return "redirect:../../index";
	}

}
