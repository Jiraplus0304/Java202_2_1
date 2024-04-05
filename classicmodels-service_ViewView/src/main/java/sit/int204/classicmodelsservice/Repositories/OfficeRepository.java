package sit.int204.classicmodelsservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Entities.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
