package CoinKeeper.dto.request;

import CoinKeeper.model.user.enums.UserRole;
import lombok.Getter;

@Getter
public class UserRequest {
    
    private String name;

    private String login;

    private String email;

    private String password;

    private UserRole role;

}
