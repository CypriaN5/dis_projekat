package disproject.svarog.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import disproject.svarog.models.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, UUID> {

}
