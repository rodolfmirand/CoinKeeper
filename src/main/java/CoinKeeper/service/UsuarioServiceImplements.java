package CoinKeeper.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import CoinKeeper.model.Conta;
import CoinKeeper.model.Usuario;
import CoinKeeper.repository.ContaRepository;
import CoinKeeper.repository.UsuarioRepository;
import CoinKeeper.util.ContaMapper;
import CoinKeeper.util.UsuarioMapper;
import dto.request.UsuarioRequestDTO;
import dto.response.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UsuarioServiceImplements implements UsuarioService {

    private final UsuarioRepository userRepository;
    private final ContaRepository contaRepository;

    private final UsuarioMapper userMapper;
    private final ContaMapper contaMapper;

    @Override
    public UsuarioResponseDTO findById(Long id) {
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
    public UsuarioResponseDTO update(UsuarioRequestDTO usuario, Long id) {
        Usuario user = searchUser(id);

        userMapper.updateUsuario(user, usuario);

        return userMapper.toUsuarioResponseDTO(userRepository.save(user));
    }

    @Override
    public String delete(Long id) {
        userRepository.deleteById(id);
        return "Usuário de id (" + id + ") deletado.";
    }

    private Usuario searchUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado do banco de dados."));
    }

}
