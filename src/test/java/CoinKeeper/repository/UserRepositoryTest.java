package CoinKeeper.repository;

import CoinKeeper.dto.request.UserRequest;
import CoinKeeper.model.user.User;
import CoinKeeper.model.user.enums.UserRole;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Deve encontrar um usuário já existente no banco")
    void findByLoginSuccess() {
        String login = "wojtz";
        UserRequest userRequest = new UserRequest("Rodolfo", login,"rodolfo@gmail.com", "cafe123", UserRole.ADMIN);
        this.registerUser(userRequest);

        Optional<User> result = this.userRepository.findByLogin(login);

        //conferindo o resultado final do teste
        assertThat(result.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Não deve encontrar um usuário já existente no banco")
    void findByLoginFailed() {
        String login = "wojtz";

        Optional<User> result = this.userRepository.findByLogin(login);

        //conferindo o resultado final do teste
        assertThat(result.isEmpty()).isTrue();
    }

    //método para criar o usuário para fazer os testes unitários
    private void registerUser(UserRequest userRequest){
        User user = new User(userRequest);
        this.entityManager.persist(user);
    }
}