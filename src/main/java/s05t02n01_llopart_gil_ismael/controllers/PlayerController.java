package s05t02n01_llopart_gil_ismael.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerCreationDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameAndSuccessRateDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameUpdaterDto;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	PlayerService playerService;
	
	@PostMapping 
	public ResponseEntity<PlayerCreationDto> createPlayer (@Valid @RequestBody PlayerCreationDto playerCreationDto) {
		
		if (playerService.findByName(playerCreationDto.getName()).isPresent() || playerService.findByEmail(playerCreationDto.getEmail()).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		playerService.save(playerCreationDto);
		
		return ResponseEntity.ok(playerCreationDto);
	}
	
	@PutMapping 
	public ResponseEntity<PlayerDto> updatePlayer (@Valid @RequestBody PlayerNameUpdaterDto playerNameUpdaterDto) {
		Optional<PlayerDto> optionalPlayerDto = playerService.findByEmail(playerNameUpdaterDto.getEmail());

		if (playerService.findByEmail(playerNameUpdaterDto.getEmail()).isPresent()) {
			PlayerDto finalPlayer = optionalPlayerDto.get();
			finalPlayer.setName(playerNameUpdaterDto.getName());
			playerService.save(finalPlayer);
			return ResponseEntity.ok(optionalPlayerDto.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<PlayerNameAndSuccessRateDto> > getAllPlayers () {
		List<PlayerDto> playerList = playerService.findAll();
		
		if (playerList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(playerService.findAllWithNameAndSuccessRate());
	}
}
