package CoinKeeper.service;

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
    public UsuarioResponseDTO register(UsuarioRequestDTO usuario) {
        Usuario user = userMapper.toUsuario(usuario);
        Conta conta = new Conta(user);
        user.setConta(conta);
        contaRepository.save(conta);
        return userMapper.toUsuarioResponseDTO(userRepository.save(user));
    }

    @Override
    public UsuarioResponseDTO registerNewUser(UsuarioRequestDTO usuario) {
        if(loginExists(usuario.getLogin()))
            return new UsuarioResponseDTO("Este login já existe.");

        if(emailExists(usuario.getEmail()))
            return new UsuarioResponseDTO("Este e-mail já existe.");

        Usuario user = userMapper.toUsuario(usuario);
        user.setSituacao(SituacaoUsuario.PENDENTE);

        // TODO - enviar um email para verificar a conta (opcional)

        Conta conta = new Conta(user);
        user.setConta(conta);
        contaRepository.save(conta);
        return userMapper.toUsuarioResponseDTO(userRepository.save(user));
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

    private boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM usuarios WHERE email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    private boolean loginExists(String login){
        String sql = "SELECT COUNT(*) FROM usuarios WHERE login = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, login);
        return count != null && count > 0;
    }
}
