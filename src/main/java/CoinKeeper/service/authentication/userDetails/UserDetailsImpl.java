package CoinKeeper.service.authentication.userDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import CoinKeeper.model.user.User;
import CoinKeeper.model.user.enums.UserRole;
import CoinKeeper.model.user.enums.UserStatus;
import lombok.Getter;

@Getter
public class UserDetailsImpl implements UserDetails {

    private UUID id;

    private String username;

    private String email;

    private String password;

    private UserStatus status;

    private UserRole role;

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getId(),
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                user.getStatus(),
                user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role.equals(UserRole.ADMIN)) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public UserDetailsImpl(UUID id, String username, String email, String password, UserStatus status,
            UserRole role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
    }

}
