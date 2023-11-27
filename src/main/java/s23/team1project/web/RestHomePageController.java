package s23.team1project.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import s23.team1project.domain.AnswerOption;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.QuestionRepository;
import s23.team1project.domain.Query;

@Controller
public class RestHomePageController {
	@Autowired
	private QuestionRepository questionRepo;
	
	@Autowired
	private QueryRepository queryRepo; 
	
	@GetMapping("/resthomepage")
	public String showQueries(Model model) {
		List<Query> queries = new ArrayList();
        queries.add(queryRepo.findById(1L).orElse(null));
        queries.add(queryRepo.findById(2L).orElse(null));
        model.addAttribute("queries", queries);
		return "resthomepage";
	}
	

}
