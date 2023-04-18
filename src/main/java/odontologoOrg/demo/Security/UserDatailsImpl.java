package odontologoOrg.demo.Security;

import lombok.AllArgsConstructor;
import odontologoOrg.demo.dentists.Dentist;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@AllArgsConstructor
public class UserDatailsImpl implements UserDetails {
    private final Dentist dentist;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return dentist.getPassword();
    }

    @Override
    public String getUsername() {
        return dentist.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getNombre(){
        return  dentist.getName();
    }
}
