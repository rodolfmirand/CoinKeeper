package CoinKeeper.service.usuario;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.UsuarioRequestDTO;
import CoinKeeper.dto.response.UsuarioResponseDTO;
import CoinKeeper.model.Conta;
import CoinKeeper.model.Usuario;
import CoinKeeper.model.enums.SituacaoUsuario;
import CoinKeeper.repository.ContaRepository;
import CoinKeeper.repository.UsuarioRepository;
import CoinKeeper.util.UsuarioMapper;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UsuarioServiceImplements implements UsuarioService {

    @Autowired
    private final UsuarioRepository userRepository;

    @Autowired
    private final ContaRepository contaRepository;

    @Autowired
    private final UsuarioMapper userMapper;

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Override
    public UsuarioResponseDTO findById(UUID id) {
        return userMapper.toUsuarioResponseDTO(searchUser(id));
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return userMapper.toUsuariosDTO(userRepository.findAll());
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
    public UsuarioResponseDTO register(UsuarioRequestDTO usuario) {
        Usuario user = userMapper.toUsuario(usuario);
        Conta conta = new Conta(user);
        user.setConta(conta);
        contaRepository.save(conta);
        return userMapper.toUsuarioResponseDTO(userRepository.save(user));
    }

    @Override
    public String registerNewUser(UsuarioRequestDTO usuario) {
        Usuario user = userMapper.toUsuario(usuario);
        user.setSituacao(SituacaoUsuario.PENDENTE);

        Conta conta = new Conta(user);
        user.setConta(conta);
        contaRepository.save(conta);
        userMapper.toUsuarioResponseDTO(userRepository.save(user));
        return "Usuário cadastrado!";
    }

    @Override
    public UsuarioResponseDTO update(UsuarioRequestDTO usuario, UUID id) {
        Usuario user = searchUser(id);

        userMapper.updateUsuario(user, usuario);

        return userMapper.toUsuarioResponseDTO(userRepository.save(user));
    }

    @Override
    public String deleteById(UUID id) {
        userRepository.deleteById(id);
        return "Usuário de id (" + id + ") deletado.";
    }

    private Usuario searchUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado do banco de dados."));
    }
}
