package odontologoOrg.demo.dentists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, Integer> {
    Optional<Dentist> findOneByEmail(String email);
}
