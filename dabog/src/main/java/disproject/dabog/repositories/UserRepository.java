package disproject.dabog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.dabog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
