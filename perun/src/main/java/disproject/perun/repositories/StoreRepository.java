package disproject.perun.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.perun.models.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, UUID> {
	
}
