package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.dto.response.UserResponse;
import CoinKeeper.model.User;

@Component
public class UserMapper {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public User toUser(UserRequest userRequest) {
        return User.builder()
                .name(userRequest.getName())
                .login(userRequest.getLogin())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user);
    }

    public List<UserResponse> toUserResponseList(List<User> usersList) {
        return usersList.stream().map(UserResponse::new).collect(Collectors.toList()); 
    }

    public void updateUser(User user, UserRequest userResquest) {
        user.setName(userResquest.getName());
        user.setLogin(userResquest.getLogin());
        user.setEmail(userResquest.getEmail());
        user.setPassword(userResquest.getPassword());
    }
}
