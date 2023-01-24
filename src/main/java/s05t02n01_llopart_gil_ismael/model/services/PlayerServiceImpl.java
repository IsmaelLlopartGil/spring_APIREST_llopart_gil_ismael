package s05t02n01_llopart_gil_ismael.model.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerCreationDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerNameAndSuccessRateDto;
import s05t02n01_llopart_gil_ismael.model.repository.PlayerRepositoryMongoDB;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerRepositoryMongoDB playerRepositoryMysql;
	
	@Autowired
	PlayerMapper playerMapper;
	
	@Override
	public void save(PlayerDto playerDto) {
		playerRepositoryMysql.save(playerMapper.convertToEntity(playerDto));
	}
	
	@Override
	public void save(PlayerCreationDto playerCreationDto) {
		playerRepositoryMysql.insert(playerMapper.convertToEntity(playerCreationDto));
	}


	@Override
	public Optional<PlayerDto> findById(String id) {
		return playerMapper.convertToOptionalDto(playerRepositoryMysql.findById(id));
	}
	
	@Override
	public Optional<PlayerDto> findByName (String name) {
		return playerMapper.convertToOptionalDto(playerRepositoryMysql.findOneByName(name));
	}
	
	@Override
	public Optional<PlayerDto> findByEmail(String email) {
		return playerMapper.convertToOptionalDto(playerRepositoryMysql.findOneByEmail(email));
	}


	@Override
	public void deleteById(String id) {
		playerRepositoryMysql.deleteById(id);
		
	}

	@Override
	public List<PlayerDto> findAll() {
		return playerMapper.convertToDto (playerRepositoryMysql.findAll());
	}
	
	@Override
	public List<PlayerNameAndSuccessRateDto> findAllWithNameAndSuccessRate() {
		return playerMapper.convertToNameAndSuccessDto (playerRepositoryMysql.findAll());
	}
}
