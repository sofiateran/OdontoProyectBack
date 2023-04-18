package odontologoOrg.demo.Security;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import odontologoOrg.demo.dentists.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDatailsServiceImpl implements UserDetailsService {
    @Autowired
    private DentistRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Dentist dentist = repository
                .findOneByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("El dentista con " + email+ "no existe"));

        return new UserDatailsImpl(dentist);
    }

}
