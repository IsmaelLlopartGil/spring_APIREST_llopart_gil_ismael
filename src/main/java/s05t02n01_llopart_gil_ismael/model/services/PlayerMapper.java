package s05t02n01_llopart_gil_ismael.model.services;

import java.util.List;
import java.util.Optional;
import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerCreationDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameAndSuccessRateDto;

public interface PlayerMapper {

	PlayerDto convertToDto (Player player);
	
	Player convertToEntity (PlayerDto playerDto);
	
	Optional<PlayerDto> convertToOptionalDto (Optional<Player> player);

	Player convertToEntity(PlayerCreationDto playerCreationDto);

	List<PlayerNameAndSuccessRateDto> convertToNameAndSuccessDto(List<Player> findAll);

	List<PlayerDto> convertToDto(List<Player> playerList);
}
