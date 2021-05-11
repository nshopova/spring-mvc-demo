package bg.proxiad.demo.mvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bg.proxiad.demo.mvc.logic.Game;
import bg.proxiad.demo.mvc.logic.GameService;

@Controller
public class HomeController {
	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	@PostMapping("/games") 
	public String createNewGame() {
		Game game = gameService.createGame();
		System.out.println("Game id: " + game.getId());
		return "redirect:/games/" +game.getId();
	}
	
	@GetMapping(value = "/games/{id}")
	public String showGame(@PathVariable String id, @RequestParam(required = false) Boolean hint, Model model) {
		System.out.println("Show game: " + id);
		System.out.println("Use hint: " + hint);
		Game game = gameService.getGame(id);
		model.addAttribute(game);
		return "hangman.html";
	}
}
