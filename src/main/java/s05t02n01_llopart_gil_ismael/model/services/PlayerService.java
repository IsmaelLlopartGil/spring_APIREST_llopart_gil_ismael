package s05t02n01_llopart_gil_ismael.model.services;

import java.util.List;
import java.util.Optional;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerCreationDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameAndSuccessRateDto;

public interface PlayerService {

	public void save(PlayerDto playerDto);
	
	public void save(PlayerCreationDto playerCreationDto);

	public Optional<PlayerDto> findById(String id);

	public void deleteById(String id);

	public List<PlayerDto> findAll();

	Optional<PlayerDto> findByEmail(String email);

	Optional<PlayerDto> findByName(String name);

	List<PlayerNameAndSuccessRateDto> findAllWithNameAndSuccessRate();
}
