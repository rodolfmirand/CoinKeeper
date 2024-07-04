package CoinKeeper.dto.response;

import java.util.UUID;

import CoinKeeper.model.User;
import CoinKeeper.model.enums.UserStatus;
import lombok.Getter;

@Getter
public class UserResponse {

    private UUID id;

    private String name;

    private String login;

    private String email;

    private String password;

    private AccountResponse accountResponse;

    private UserStatus userStatus;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.accountResponse = new AccountResponse(user.getAccount());
        this.userStatus = user.getStatus();
    }

    public UserResponse() {
        this.id = null;
        this.name = null;
        this.login = null;
        this.email = null;
        this.password = null;
        this.accountResponse = null;
        this.userStatus = null;
    }
}
