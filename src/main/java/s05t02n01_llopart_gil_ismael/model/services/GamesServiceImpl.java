package s05t02n01_llopart_gil_ismael.model.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s05t02n01_llopart_gil_ismael.model.domain.Player;
import s05t02n01_llopart_gil_ismael.model.dto.RollDto;
import s05t02n01_llopart_gil_ismael.model.repository.PlayerRepositoryMysql;
import s05t02n01_llopart_gil_ismael.model.repository.RollRepositoryMysql;

@Service
public class GamesServiceImpl implements GamesService{

	@Autowired
	RollRepositoryMysql rollRepositoryMysql;
	
	@Autowired
	PlayerRepositoryMysql playerRepositoryMysql;
	
	@Autowired
	RollMapper rollMapper;
	
	@Override
	public void save(RollDto rollDto) {
		Optional<Player> optionalPlayer = playerRepositoryMysql.findById(rollDto.getPlayerId());
		
		if (optionalPlayer.isPresent()) {
			rollRepositoryMysql.save(rollMapper.convertToEntity(rollDto, optionalPlayer.get()));
		}
	}


}