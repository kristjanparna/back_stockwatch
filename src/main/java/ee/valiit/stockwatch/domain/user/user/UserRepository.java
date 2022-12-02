package ee.valiit.stockwatch.domain.user.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = ?1 and u.password = ?2")
    Optional<User> findUserBy(String username, String password);

    @Query("select u from User u where u.username = ?1")
    User findUserByUsername(String username);
}