package CoinKeeper.dto.request;

import lombok.Getter;

@Getter
public class AuthenticationRequestDTO {
    
    private String username;

    private String password;
}
