package s23.team1project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s23.team1project.domain.AnswerOption;
import s23.team1project.domain.AnswerOptionRepository;
import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.Question;
import s23.team1project.domain.QuestionRepository;

@Controller
public class AnswerOptionController {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerOptionRepository answerOptionRepo;
	
	// Adding AnswerOption
	@GetMapping("query/{queryId}/question/{questionId}/addansweroption")
	public String addQuestion(@PathVariable("questionId") Long questionId, Model model) {
		model.addAttribute("question", questionRepo.findById(questionId).get());
		model.addAttribute("answerOption", new AnswerOption());
		return "addansweroption";
	}
	
	// Saving AnswerOption
	@PostMapping("query/{queryId}/question/{questionId}/saveansweroption")
	public String saveAnswerOption(@PathVariable("questionId") Long questionId, AnswerOption answerOption) {
		Question question = questionRepo.findById(questionId).get();
		answerOptionRepo.save(answerOption);
		return "redirect:../../../{queryId}/listquestions";
	}
	
}