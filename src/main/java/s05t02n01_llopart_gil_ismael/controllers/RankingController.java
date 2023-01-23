package s05t02n01_llopart_gil_ismael.controllers;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameAndSuccessRateDto;
import s05t02n01_llopart_gil_ismael.model.services.PlayerService;

@RestController
@RequestMapping ("/players/ranking")
public class RankingController {

	@Autowired
	PlayerService playerService;
	
	@GetMapping 
	public ResponseEntity<Integer>  getAverageSuccessRateAllUsers () {
		List<PlayerNameAndSuccessRateDto> playerNameAndSuccessRateDtoList = playerService.findAllWithNameAndSuccessRate();
		Integer total = 0;
		
		for (PlayerNameAndSuccessRateDto playerNameAndSuccessRateDto : playerNameAndSuccessRateDtoList) {
			total += playerNameAndSuccessRateDto.getSuccessRate();
		}
		return ResponseEntity.ok(total / playerNameAndSuccessRateDtoList.size());
	}
	
	@GetMapping ("/loser")
	public ResponseEntity<PlayerNameAndSuccessRateDto>  getLoserUser () {
		List<PlayerNameAndSuccessRateDto> playerNameAndSuccessRateDtoList = playerService.findAllWithNameAndSuccessRate();
		
		return ResponseEntity.ok(Collections.min(playerNameAndSuccessRateDtoList, (o1, o2) -> o1.compareTo(o2) ));
	}
	
	@GetMapping ("/winner")
	public ResponseEntity<PlayerNameAndSuccessRateDto>  getWinnerUser () {
		List<PlayerNameAndSuccessRateDto> playerNameAndSuccessRateDtoList = playerService.findAllWithNameAndSuccessRate();
		
		return ResponseEntity.ok(Collections.max(playerNameAndSuccessRateDtoList, (o1, o2) -> o1.compareTo(o2) ));
	}
}
