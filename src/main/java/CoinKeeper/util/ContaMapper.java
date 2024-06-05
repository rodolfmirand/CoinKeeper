package CoinKeeper.util;

import org.springframework.stereotype.Component;

import CoinKeeper.model.Conta;
import CoinKeeper.model.Usuario;
import dto.request.UsuarioRequestDTO;
import dto.response.ContaResponseDTO;

@Component
public class ContaMapper {
    
    public Conta toConta(UsuarioRequestDTO usuario) {

        Usuario user = new UsuarioMapper().toUsuario(usuario);

        return new Conta(user.getNome(), user.getEmail(), user.getSenha(), user);
    }

    public ContaResponseDTO toContaResponseDTO(Conta conta){
        return new ContaResponseDTO(conta);
    }
}
