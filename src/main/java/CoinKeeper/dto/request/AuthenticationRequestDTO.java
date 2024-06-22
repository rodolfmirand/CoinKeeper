package CoinKeeper.dto.request;

import lombok.Getter;

@Getter
public class AuthenticationRequestDTO {
    
    private String login;

    private String password;
}
