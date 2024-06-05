package CoinKeeper.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import CoinKeeper.model.Usuario;
import CoinKeeper.repository.UsuarioRepository;
import CoinKeeper.util.UsuarioMapper;
import dto.request.UsuarioRequestDTO;
import dto.response.UsuarioResponseDTO;
import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class UsuarioServiceImplements implements UsuarioService {

    private final UsuarioRepository repository;

    private final UsuarioMapper mapper;

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return mapper.toUsuarioResponseDTO(searchUser(id));
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return mapper.toUsuariosDTO(repository.findAll());
    }

    @Override
    public UsuarioResponseDTO register(UsuarioRequestDTO usuario) {
        Usuario user = mapper.toUsuario(usuario);
        return mapper.toUsuarioResponseDTO(repository.save(user));
    }

    @Override
    public UsuarioResponseDTO update(UsuarioRequestDTO usuario, Long id) {
        Usuario user = searchUser(id);

        mapper.updateUsuario(user, usuario);

        return mapper.toUsuarioResponseDTO(repository.save(user));
    }

    @Override
    public String delete(Long id) {
        repository.deleteById(id);
        return "Usuário de id (" + id + ") deletado.";
    }

    private Usuario searchUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado do banco de dados."));
    }

}
