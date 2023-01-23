package s05t02n01_llopart_gil_ismael.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.RollDto;
import s05t02n01_llopart_gil_ismael.model.services.GamesService;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@RestController
@RequestMapping ("/players/{id}/games")
public class GameController {
	
	@Autowired
	GamesService gamesService;
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping
	public ResponseEntity<RollDto>  rollDice (@PathVariable int id) {
		Optional<PlayerDto> optionalPlayerDto = playerService.findById(id);
		
		if (optionalPlayerDto.isPresent()) {
			RollDto rollDto = new RollDto(id);
			gamesService.save(rollDto);
			return ResponseEntity.ok(rollDto);
		}
			
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping
	public ResponseEntity<PlayerDto>  deleteRolls (@PathVariable int id) {
		Optional<PlayerDto> optionalPlayerDto = playerService.findById(id);
		
		if (optionalPlayerDto.isPresent()) {
			optionalPlayerDto.get().setRolls(new ArrayList<>());
			playerService.deleteById(id);
			playerService.save(optionalPlayerDto.get());
			return ResponseEntity.ok(optionalPlayerDto.get());
		}
			
		return ResponseEntity.notFound().build();	
	}
	
	@GetMapping
	public ResponseEntity<List<RollDto>>  getAllRolls (@PathVariable int id) {
		Optional<PlayerDto> optionalPlayerDto = playerService.findById(id);
		
		if (optionalPlayerDto.isPresent()) {		
			return ResponseEntity.ok(optionalPlayerDto.get().getRolls());
		}
			
		return ResponseEntity.notFound().build();	
	}
}
