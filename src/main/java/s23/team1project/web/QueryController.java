package s23.team1project.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import s23.team1project.domain.Query;
import s23.team1project.domain.QueryRepository;

@Controller
public class QueryController {

	@Autowired
	private QueryRepository queryRepo;

	// Query listing
	@GetMapping("/index")
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
	
	@GetMapping("deletequery/{id}")
	public String deleteQuery(@PathVariable ("id") Long id) {
		queryRepo.deleteById(id);
		return "redirect:/index";
	}

}
