package s05t02n01_llopart_gil_ismael.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@Controller
@RequestMapping ({"/jocdelset", "/"})
public class JocDelSetController {

	@Autowired
	PlayerService playerService;
	
	@RequestMapping 
	public String getHomePage () {
		return "jocdelset";
	}
	
	@RequestMapping ("/login")
	public String getLogin () {
		return "login";
	}
	
	@RequestMapping ("/loginerror")
	public String getLoginError () {
		return "loginerror";
	}
	
	@GetMapping ("/create_user")
	public String getCreateUserForm (Model model) {
		PlayerDto player = new PlayerDto();
		model.addAttribute("player", player);
		return "create_user";
	}
	
	@PostMapping ("/create_user")
	public String setUser (@ModelAttribute("player") PlayerDto playerDto, Model model) {
				
		if (playerDto.getName().isEmpty()) {
			playerDto = getAnonymousUser();
			model.addAttribute("result", "Jugarà com a usuari anònim.");
			model.addAttribute("startpageName", "Jugar");
			model.addAttribute("startpage", "/players");
		} else {
			
			if (playerService.findByName(playerDto.getName()).isPresent()) {
				model.addAttribute("result", "l'usuari ja existeix.");
				model.addAttribute("startpageName", "Intentar-ho de nou");
				model.addAttribute("startpage", "/jocdelset/create_user");
			} else {
				playerService.save(playerDto);
				model.addAttribute("result", "Compte creat.");
				model.addAttribute("startpageName", "login");
				model.addAttribute("startpage", "/login");
			}	
		}
		
		return "registration_result";
	}

	private PlayerDto getAnonymousUser() {
		Optional<PlayerDto> optionalAnomymousPlayer = playerService.findByName("Anonymous");
		
		if(optionalAnomymousPlayer.isPresent()) {
			return optionalAnomymousPlayer.get();
		} else {
			PlayerDto anonymousPlayer = new PlayerDto();
			anonymousPlayer.setName("Anonymous");
			anonymousPlayer.setPassword("");
			playerService.save(anonymousPlayer);
		}
		
		return playerService.findByName("Anonymous").get();
	}
}

