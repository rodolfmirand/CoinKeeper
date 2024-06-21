package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
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

    private final UsuarioRepository userRepository;
    private final ContaRepository contaRepository;

    private final UsuarioMapper userMapper;

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

}
