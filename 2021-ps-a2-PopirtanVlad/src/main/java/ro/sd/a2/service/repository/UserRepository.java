package ro.sd.a2.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.sd.a2.entity.UsersEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, String> {

    @Query("SELECT u FROM UsersEntity u WHERE LOWER(u.user_email) = LOWER(:email)")
    public UsersEntity find(@Param("email") String email);

}
