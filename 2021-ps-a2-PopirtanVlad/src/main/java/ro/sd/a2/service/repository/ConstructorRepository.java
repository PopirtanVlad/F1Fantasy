package ro.sd.a2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.Constructor;
import ro.sd.a2.entity.UsersEntity;

@Repository
public interface ConstructorRepository extends JpaRepository<Constructor,String> {

    @Query("SELECT c FROM Constructor c WHERE LOWER(c.constructor_id) = LOWER(:id)")
    public Constructor findConstructorById(@Param("id") String id);
}
