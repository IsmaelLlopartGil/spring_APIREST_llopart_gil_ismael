package s05t02n01_llopart_gil_ismael.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import s05t02n01_llopart_gil_ismael.model.dto.PlayerCreationDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@RestController
@RequestMapping ({"/"})
public class JocDelSetController {
	
	@Autowired
	PlayerService playerService;
	
	@GetMapping ("/load_default_user")
	public ResponseEntity<PlayerDto> loadDefaultUser () {
		Optional<PlayerDto> optionalPlayerDto = playerService.findByEmail("default_user@jocdelset.edu");
		
		if (!optionalPlayerDto.isPresent()) {
			PlayerCreationDto defaultPlayerCreationDto = new PlayerCreationDto();
			defaultPlayerCreationDto.setName("Default User");
			defaultPlayerCreationDto.setEmail("default_user@jocdelset.edu");
			defaultPlayerCreationDto.setPassword("pass");
			playerService.save(defaultPlayerCreationDto);
			return ResponseEntity.ok(playerService.findByEmail("default_user@jocdelset.edu").get());
		} 
	
		return ResponseEntity.ok(optionalPlayerDto.get());	
	}
	
	
}

