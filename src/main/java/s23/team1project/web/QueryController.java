package s23.team1project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;
import s23.team1project.domain.QuestionRepository;

@Controller
public class QueryController {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private QueryRepository queryRepo;
	
	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("queries", queryRepo.findAll());
		return "index";
	}
	
	@GetMapping("addQuery")
	public String addQuery(Model model) {
		model.addAttribute("query", new Query());
		return "addquery";
	}
	
	@PostMapping("save")
	public String save(Query query) {
		queryRepo.save(query);
		return "redirect:index";
	}
	
}
