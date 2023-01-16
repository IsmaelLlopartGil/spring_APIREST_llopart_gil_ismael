package s05t02n01_llopart_gil_ismael.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@Controller
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	@PostMapping 
	public String createPlayer (@RequestParam PlayerDto playerDto) {
		playerService.save(playerDto);
		return "";
	}
	
	@PutMapping 
	public String updatePlayer (@RequestParam PlayerDto playerDto) {
		playerService.save(playerDto);
		return "";
	}
	
	@GetMapping
	public String getAllPlayers () {
		
		return "";
	}
}
