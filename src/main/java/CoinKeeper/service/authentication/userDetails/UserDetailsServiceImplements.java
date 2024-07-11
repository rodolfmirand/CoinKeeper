package CoinKeeper.service.authentication.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import CoinKeeper.model.user.User;
import CoinKeeper.repository.UserRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService{

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(repository.findByLogin(username).get());
    }
    
}
