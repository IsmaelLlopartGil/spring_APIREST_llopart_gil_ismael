package s05t02n01_llopart_gil_ismael.model.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import s05t02n01_llopart_gil_ismael.model.dto.PlayerDto;
import s05t02n01_llopart_gil_ismael.model.repository.PlayerRepositoryMysql;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerRepositoryMysql playerRepositoryMysql;
	
	@Autowired
	PlayerMapper playerMapper;
	
	@Override
	public void save(PlayerDto playerDto) {
		playerDto.setRegistrationDate(LocalDateTime.now());
		playerDto.setRolls(new ArrayList<>());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		playerDto.setPassword(encoder.encode(playerDto.getPassword()));
		playerRepositoryMysql.save(playerMapper.convertToEntity(playerDto));
	}

	@Override
	public Optional<PlayerDto> findById(int id) {
		return playerMapper.convertToOptionalDto(playerRepositoryMysql.findById(id));
	}
	
	@Override
	public Optional<PlayerDto> findByName(String name) {
		return playerMapper.convertToOptionalDto(playerRepositoryMysql.findOneByName(name));
	}


	@Override
	public void deleteById(int id) {
		playerRepositoryMysql.deleteById(id);
		
	}

	@Override
	public List<PlayerDto> findAll() {
		return playerMapper.convertToListDto (playerRepositoryMysql.findAll());
	}
}
