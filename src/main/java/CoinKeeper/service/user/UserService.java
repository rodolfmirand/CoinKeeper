package CoinKeeper.service.user;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.dto.response.UserResponse;

public interface UserService {

    UserResponse findById(UUID id);

    List<UserResponse> findAll();

    boolean verifyLogin(String login);

    boolean verifyEmail(String email);

    UserResponse register(UserRequest user);

    String registerNewUser(UserRequest user);

    UserResponse update(UserRequest user, UUID id);

    String deleteById(UUID id);
}
