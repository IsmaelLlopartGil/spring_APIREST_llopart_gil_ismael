package s05t02n01_llopart_gil_ismael.controllers.services;

import java.util.List;
import java.util.Optional;
import s05t02n01_llopart_gil_ismael.views.dto.PlayerDto;

public interface PlayerService {

	public void save(PlayerDto playerDto);

	public Optional<PlayerDto> findById(int id);

	public void deleteById(int id);

	public List<PlayerDto> findAll();

}
