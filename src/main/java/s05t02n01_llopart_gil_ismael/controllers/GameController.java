package s05t02n01_llopart_gil_ismael.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/players/{id}/games")
public class GameController {

	@PostMapping
	public String rollDice (@PathVariable int id) {
		
		return "";
	}
	
	@DeleteMapping
	public String deleteRolls (@PathVariable int id) {
		
		return "";
	}
	
	@GetMapping
	public String getAllRolls (@PathVariable int id) {
		
		return "";
	}
}
