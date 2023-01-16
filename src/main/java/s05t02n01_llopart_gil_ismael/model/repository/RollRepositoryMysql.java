package s05t02n01_llopart_gil_ismael.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import s05t02n01_llopart_gil_ismael.model.domain.Roll;

@Repository
public interface RollRepositoryMysql extends JpaRepository<Roll, Integer> {

}
