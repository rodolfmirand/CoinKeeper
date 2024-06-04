package CoinKeeper.service;

import java.util.List;

import CoinKeeper.repository.UsuarioRepository;
import dto.request.UsuarioRequestDTO;
import dto.response.UsuarioResponseDTO;

public class UsuarioServiceImplements implements UsuarioService {

    private UsuarioRepository repository;

    @Override
    public UsuarioResponseDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public UsuarioResponseDTO register(UsuarioRequestDTO usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public UsuarioResponseDTO update(UsuarioRequestDTO usuario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public UsuarioResponseDTO delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
