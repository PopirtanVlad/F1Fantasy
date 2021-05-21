package ro.sd.a2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race,String> {
}
