package ee.valiit.stockwatch.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findContactByUserId(Integer id);

}