package s05t02n01_llopart_gil_ismael.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import s05t02n01_llopart_gil_ismael.model.dto.RollDto;
import s05t02n01_llopart_gil_ismael.model.repository.RollRepositoryMongoDB;

@Service
public class RollServiceImpl implements RollService {

	@Autowired
	RollRepositoryMongoDB rollRepositoryMysql;

	@Autowired
	RollMapper rollMapper;

	@Override
	public RollDto save(RollDto rollDto) {
		return rollMapper.convertToDto( rollRepositoryMysql.save(rollMapper.convertToEntity(rollDto)));
	}
}