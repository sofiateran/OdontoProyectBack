package odontologoOrg.demo.Security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService {

    private UserDetailsService service;
    private PasswordEncoder encoder;

    public UserDetails validation(AuthCredentials authCredentials){
        var usuariobd = service.loadUserByUsername(authCredentials.getEmail());

     if (! encoder.matches(authCredentials.getPassword(),usuariobd.getPassword())){
         throw new BadCredentialsException("malas credenciales");
     }
        return usuariobd;
    }
}
