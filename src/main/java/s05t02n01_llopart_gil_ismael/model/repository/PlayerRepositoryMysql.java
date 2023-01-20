package s05t02n01_llopart_gil_ismael.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s05t02n01_llopart_gil_ismael.model.domain.Player;


@Repository
public interface PlayerRepositoryMysql extends JpaRepository<Player, Integer>  {

	Optional<Player> findOneByName (String name);
}
