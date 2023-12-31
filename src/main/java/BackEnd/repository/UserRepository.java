package BackEnd.repository;

import BackEnd.dto.EmployeeDto;
import BackEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserNameOrEmail(String userName, String email);
   Optional<User> findByUserName(String userName);
}
