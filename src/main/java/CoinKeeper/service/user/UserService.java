package CoinKeeper.service.user;

import java.util.List;
import java.util.UUID;

import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.dto.response.UserResponse;
import CoinKeeper.model.user.User;

public interface UserService {

    UserResponse findById(UUID id);

    User findUserById(UUID id);

    List<UserResponse> findAll();

    boolean verifyLogin(String login);

    boolean verifyEmail(String email);

    // UserResponse register(UserRequest user);

    String register(UserRequest user);

    UserResponse update(UserRequest user, UUID id);

    String deleteById(UUID id);

    void updateUserStatus(UUID id, String code);
}
