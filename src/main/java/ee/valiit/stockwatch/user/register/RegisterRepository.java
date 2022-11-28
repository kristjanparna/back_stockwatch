package ee.valiit.stockwatch.user.register;

import ee.valiit.stockwatch.user.login.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<User, Integer> {

}