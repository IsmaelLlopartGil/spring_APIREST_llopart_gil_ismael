package s05t02n01_llopart_gil_ismael.model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerCreationDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameAndSuccessRateDto;

@Component 
public class PlayerMapperImpl implements PlayerMapper {

	@Autowired
	private RollMapperImpl rollMapper;
	
	public PlayerMapperImpl () {
	}
	
	@Override
	public PlayerDto convertToDto(Player player) {
		PlayerDto playerDto = new PlayerDto();
		playerDto.setId(player.getId());
		playerDto.setName(player.getName());
		playerDto.setRegistrationDate(player.getRegistrationDate());
		playerDto.setPassword(player.getPassword());
		playerDto.setEmail(player.getEmail());
		playerDto.setRolls(rollMapper.convertToListDto(player.getRolls()));
		return playerDto;
	}

	@Override
	public Player convertToEntity(PlayerDto playerDto) {
		Player player = new Player();
		player.setId(playerDto.getId());
		player.setName(playerDto.getName());
		player.setRegistrationDate(playerDto.getRegistrationDate());
		player.setPassword(playerDto.getPassword());
		player.setEmail(playerDto.getEmail());
		player.setRolls(rollMapper.convertToListEntity(playerDto.getRolls()));
		return player;
	}
	
	@Override
	public Player convertToEntity(PlayerCreationDto playerCreationDto) {
		Player player = new Player();
		player.setName(playerCreationDto.getName());
		player.setRegistrationDate(LocalDateTime.now());
		player.setRolls(new ArrayList<>());
		player.setEmail(playerCreationDto.getEmail());
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String password = playerCreationDto.getPassword();
		player.setPassword(bCryptPasswordEncoder.encode(password));
		
		if (playerCreationDto.getName() == null || playerCreationDto.getName().isBlank()) {
			playerCreationDto.setName("Anònim");
		}
		return player;
	}

	@Override
	public Optional<PlayerDto> convertToOptionalDto(Optional<Player> player) {
		
		if (player.isPresent()) {
			return Optional.of(convertToDto(player.get()));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public List<PlayerDto> convertToDto(List<Player> playerList) {
		List<PlayerDto> playerDtoList = new ArrayList<>();
		
		for (Player player : playerList) {
			playerDtoList.add(convertToDto(player));
		}
		
		return playerDtoList;
	}

	@Override
	public List<PlayerNameAndSuccessRateDto> convertToNameAndSuccessDto(List<Player> playerList) {
		List<PlayerNameAndSuccessRateDto> playerNameAndSuccessRateDtoList = new ArrayList<>();
		
		for (Player player : playerList) {
			playerNameAndSuccessRateDtoList.add(new PlayerNameAndSuccessRateDto(
					player.getName(),
					player.getEmail(),
					rollMapper.convertToListDto(player.getRolls())
					));
		}
		
		return playerNameAndSuccessRateDtoList;
	}
}
