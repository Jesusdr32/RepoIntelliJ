package jesusdr.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AppUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        return null;
    }
}
