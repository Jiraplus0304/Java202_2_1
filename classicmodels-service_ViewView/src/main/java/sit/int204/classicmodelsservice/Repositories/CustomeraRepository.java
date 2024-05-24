package sit.int204.classicmodelsservice.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.Entities.Customera;

import java.util.List;

public interface CustomeraRepository extends JpaRepository<Customera, Long> {
    List<Customera> findByFirstNameContains(String param);

}
