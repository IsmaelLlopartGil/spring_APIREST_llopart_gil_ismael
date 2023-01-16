package s05t02n01_llopart_gil_ismael.model.services;

import java.util.List;
import java.util.Optional;
import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;

public interface PlayerMapper {

	public PlayerDto convertToDto (Player player);
	
	public Player convertToEntity (PlayerDto playerDto);
	
	public Optional<PlayerDto> convertToOptionalDto (Optional<Player> player);
	
	public List<PlayerDto> convertToListDto (List<Player> playerList);
}
