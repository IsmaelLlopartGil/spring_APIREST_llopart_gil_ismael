package s05t02n01_llopart_gil_ismael.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/players/ranking")
public class RankingController {

	@GetMapping 
	public String getAverageSuccessRateAllUsers () {
		
		return "";
	}
	
	@GetMapping ("/loser")
	public String getLoserUser () {
		
		return "";
	}
	
	@GetMapping ("/winner")
	public String getWinnerUser () {
		
		return "";
	}
}
