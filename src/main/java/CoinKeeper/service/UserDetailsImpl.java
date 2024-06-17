package CoinKeeper.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import CoinKeeper.model.Usuario;

public class UserDetailsImpl implements UserDetails {

    private UUID id;

    private String userName;

    private String email;

    private String password;

    public static UserDetailsImpl build(Usuario user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getSenha(),
                new ArrayList<>());
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    public UserDetailsImpl(UUID id, String userName, String email, String password,
            Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

}
