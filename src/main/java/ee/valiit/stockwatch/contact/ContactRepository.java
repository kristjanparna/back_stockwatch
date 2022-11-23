package ee.valiit.stockwatch.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Query("select c from Contact c where c.user.id = ?1")
    List<Contact> findContactByUserId(Integer id);


}