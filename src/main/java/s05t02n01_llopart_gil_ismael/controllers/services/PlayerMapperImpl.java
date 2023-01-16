package s05t02n01_llopart_gil_ismael.controllers.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.views.dto.PlayerDto;

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
		playerDto.setRolls(rollMapper.convertToListDto(player.getRolls()));
		return playerDto;
	}

	@Override
	public Player convertToEntity(PlayerDto playerDto) {
		Player player = new Player();
		player.setId(playerDto.getId());
		player.setName(playerDto.getName());
		player.setRegistrationDate(playerDto.getRegistrationDate());
		player.setRolls(rollMapper.convertToListEntity(playerDto.getRolls()));
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
	public List<PlayerDto> convertToListDto(List<Player> playerList) {
		List<PlayerDto> playerDtoList = new ArrayList<>();
		
		for (Player player : playerList) {
			playerDtoList.add(convertToDto(player));
		}
		
		return playerDtoList;
	}
}
