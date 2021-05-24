package disproject.dabog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.dabog.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, UUID> {

}
