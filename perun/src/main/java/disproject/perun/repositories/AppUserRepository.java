package disproject.perun.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.perun.models.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

}
