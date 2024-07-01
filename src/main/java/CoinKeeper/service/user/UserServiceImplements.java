package CoinKeeper.service.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.dto.response.UserResponse;
import CoinKeeper.model.Account;
import CoinKeeper.model.User;
import CoinKeeper.model.enums.UserStatus;
import CoinKeeper.repository.AccountRepository;
import CoinKeeper.repository.UserRepository;
import CoinKeeper.util.UserMapper;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UserServiceImplements implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AccountRepository accountRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UserResponse findById(UUID id) {
        return userMapper.toUserResponse(searchUser(id));
    }

    @Override
    public List<UserResponse> findAll() {
        return userMapper.toUserResponseList(userRepository.findAll());
    }

    @Override
    public boolean verifyLogin(String login) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, login);
        return count != null && count > 0;
    }

    @Override
    public boolean verifyEmail(String email) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    @Override
    public UserResponse register(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        Account account = new Account(user);
        user.setAccount(account);
        accountRepository.save(account);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public String registerNewUser(UserRequest userRequest) {
        User user = userMapper.toUser(userRequest);
        user.setStatus(UserStatus.PENDENTE);

        Account account = new Account(user);
        user.setAccount(account);
        accountRepository.save(account);
        userMapper.toUserResponse(userRepository.save(user));
        return "Usuário cadastrado!";
    }

    @Override
    public UserResponse update(UserRequest userRequest, UUID id) {
        User user = searchUser(id);

        userMapper.updateUser(user, userRequest);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public String deleteById(UUID id) {
        userRepository.deleteById(id);
        return "Usuário de id (" + id + ") deletado.";
    }

    private User searchUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado do banco de dados."));
    }
}
