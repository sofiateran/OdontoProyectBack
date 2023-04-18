package odontologoOrg.demo.dentists;



import odontologoOrg.demo.Security.AuthCredentials;
import odontologoOrg.demo.Security.AuthResponse;
import odontologoOrg.demo.Security.SecurityService;
import odontologoOrg.demo.Security.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
    public class Authenticate {

        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private UserDetailsService userDetailsService;
        @Autowired
        private TokenUtils tokenUtils;
        @Autowired
        private SecurityService service;

        @PostMapping(value = "/authenticate")
        public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthCredentials authCredentials) {

            final UserDetails userDetails = service.validation(authCredentials);
            final String jwt = TokenUtils.createToken(userDetails);

            return ResponseEntity.ok(new AuthResponse((jwt)));
        }

    }

