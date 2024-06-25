package CoinKeeper.service.usuario.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import CoinKeeper.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImplements implements UserDetailsService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return UserDetailsImpl.build(repository.findByLogin(username).get());
    }
    
}
