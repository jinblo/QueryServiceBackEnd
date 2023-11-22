package s23.team1project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import s23.team1project.domain.AnswerOptionRepository;
import s23.team1project.domain.QuestionRepository;

@Controller
public class AnswerOptionController {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private AnswerOptionRepository answerOptionRepo;
	
	
}
