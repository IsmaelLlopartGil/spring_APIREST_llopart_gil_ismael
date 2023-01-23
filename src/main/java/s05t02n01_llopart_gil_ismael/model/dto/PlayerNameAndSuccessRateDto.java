package s05t02n01_llopart_gil_ismael.model.dto;

import java.util.List;
import jakarta.validation.constraints.NotBlank;

public class PlayerNameAndSuccessRateDto implements Comparable<PlayerNameAndSuccessRateDto>{
	
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	private int successRate;

	public PlayerNameAndSuccessRateDto (String name, String email, List<RollDto> rollList) {
		this.name = name;
		this.email = email;
		
		if (rollList == null || rollList.isEmpty()) {
			successRate = 0;
		} else {
			int totalAttempts = rollList.size();
			int totalSuccesses = 0;
			
			for (RollDto rollDto : rollList) {
				if (rollDto.isWinner()) {
					totalSuccesses += 1;
				}
			}		
			successRate = ((totalSuccesses * 100)/totalAttempts);
		}
	}
	
	public int getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(int successRate) {
		this.successRate = successRate;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(PlayerNameAndSuccessRateDto playerNameAndSuccessRateDto) {
		return successRate - playerNameAndSuccessRateDto.getSuccessRate();
	}

	

}
