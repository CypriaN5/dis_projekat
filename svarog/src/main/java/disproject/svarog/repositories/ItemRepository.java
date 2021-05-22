package disproject.svarog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.svarog.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

}
