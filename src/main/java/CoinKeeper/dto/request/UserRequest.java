package CoinKeeper.dto.request;

import CoinKeeper.model.user.User;
import CoinKeeper.model.user.enums.UserRole;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequest {
    
    private String name;

    private String login;

    private String email;

    private String password;

    private UserRole role;

    @Builder
    public UserRequest(String name, String login, String email, String password, UserRole role) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
