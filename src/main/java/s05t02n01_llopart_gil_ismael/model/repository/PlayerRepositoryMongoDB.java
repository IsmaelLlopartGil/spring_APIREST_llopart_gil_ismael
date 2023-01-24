package s05t02n01_llopart_gil_ismael.model.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import s05t02n01_llopart_gil_ismael.model.domain.Player;


@Repository
public interface PlayerRepositoryMongoDB extends MongoRepository<Player, String>  {

	Optional<Player> findOneByEmail (String email);
	Optional<Player> findOneByName (String name);
}
