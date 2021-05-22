package disproject.perun.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.perun.models.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, UUID> {

}
