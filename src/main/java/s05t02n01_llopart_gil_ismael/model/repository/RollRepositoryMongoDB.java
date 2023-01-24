package s05t02n01_llopart_gil_ismael.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import s05t02n01_llopart_gil_ismael.model.domain.Roll;

@Repository
public interface RollRepositoryMongoDB extends MongoRepository<Roll, String> {
	
}
