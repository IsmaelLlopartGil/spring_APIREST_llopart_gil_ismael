package s05t02n01_llopart_gil_ismael.model.services;

import java.util.List;
import java.util.Optional;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;

public interface PlayerService {

	public void save(PlayerDto playerDto);

	public Optional<PlayerDto> findById(int id);

	public void deleteById(int id);

	public List<PlayerDto> findAll();

	Optional<PlayerDto> findByName(String name);

}
