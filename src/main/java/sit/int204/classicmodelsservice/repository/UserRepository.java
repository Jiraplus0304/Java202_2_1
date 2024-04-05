package sit.int204.classicmodelsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodelsservice.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
