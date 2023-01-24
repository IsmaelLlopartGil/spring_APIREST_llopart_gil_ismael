package s05t02n01_llopart_gil_ismael.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.RollDto;
import s05t02n01_llopart_gil_ismael.model.services.RollService;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@RestController
@RequestMapping ("/players/{id}/games")
public class GameController {
	
	@Autowired
	RollService gamesService;
	
	@Autowired
	PlayerService playerService;
	
	@PostMapping
	public ResponseEntity<RollDto>  rollDice (@PathVariable String id) {
		Optional<PlayerDto> optionalPlayerDto = playerService.findById(id);
		
		if (optionalPlayerDto.isPresent()) {
			RollDto rollDto = new RollDto();
			rollDto = gamesService.save(rollDto);
			
			List<RollDto> rollList = optionalPlayerDto.get().getRolls();
			rollList.add(rollDto);
			optionalPlayerDto.get().setRolls(rollList);
			playerService.save(optionalPlayerDto.get());

			return ResponseEntity.ok(rollDto);
		}
			
		return ResponseEntity.notFound().build();	
	}
	
	@DeleteMapping
	public ResponseEntity<PlayerDto>  deleteRolls (@PathVariable String id) {
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
	public ResponseEntity<List<RollDto>>  getAllRolls (@PathVariable String id) {
		Optional<PlayerDto> optionalPlayerDto = playerService.findById(id);
		
		if (optionalPlayerDto.isPresent()) {		
			return ResponseEntity.ok(optionalPlayerDto.get().getRolls());
		}
			
		return ResponseEntity.notFound().build();	
	}
}
