package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.user.User;
import CoinKeeper.model.user.enums.UserRole;
import CoinKeeper.model.user.enums.UserStatus;
import lombok.Getter;

@Getter
public class UserResponse {

    private UUID id;

    private String name;

    private String login;

    private String email;

    private String password;

    private AccountResponse accountResponse;

    private UserStatus status;

    private UserRole role;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.accountResponse = new AccountResponse(user.getAccount());
        this.status = user.getStatus();
        this.role = user.getRole();
    }

    public UserResponse() {
        this.id = null;
        this.name = null;
        this.login = null;
        this.email = null;
        this.password = null;
        this.accountResponse = null;
        this.status = null;
        this.role = null;
    }
}
