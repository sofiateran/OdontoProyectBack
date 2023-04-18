package odontologoOrg.demo.Security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCredentials {
    private String email, password;

    public AuthCredentials() {
    }
}
