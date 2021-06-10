package disproject.svarog.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import disproject.svarog.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
	
	@Query(value = "SELECT * from \"Item\" i where " +
		    "i.ean13 IN (:eans)", nativeQuery = true)
	public List<Item> findItemsByEan(@Param("eans") List<String> eans);
}
