package s23.team1project.web;

import java.util.List;

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
public class QueryController {

	@Autowired
	private QuestionRepository questionRepo;
	@Autowired
	private QueryRepository queryRepo;

	// Query listing
	@GetMapping("index")
	public String index(Model model) {
		model.addAttribute("queries", queryRepo.findAll());
		return "index";
	}

	// Query adding
	@GetMapping("addquery")
	public String addQuery(Model model) {
		model.addAttribute("query", new Query());
		return "addquery";
	}

	// Query saving
	@PostMapping("savequery")
	public String saveQuery(Query query) {
		queryRepo.save(query);
		return "redirect:index";
	}

}
