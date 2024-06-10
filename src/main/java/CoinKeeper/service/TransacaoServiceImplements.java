package CoinKeeper.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.TransacaoRequestDTO;
import CoinKeeper.dto.response.TransacaoResponseDTO;
import CoinKeeper.model.Transacao;
import CoinKeeper.repository.TransacaoRepository;
import CoinKeeper.util.TransacaoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImplements implements TransacaoService {

    @Autowired
    private final TransacaoRepository transacaoRepository;

    private final TransacaoMapper transacaoMapper;

    @Override
    public List<TransacaoResponseDTO> findAll() {
        return transacaoMapper.toTransacoesResponseDTO(transacaoRepository.findAll());
    }

    @Override
    public TransacaoResponseDTO register(TransacaoRequestDTO transacaoRequestDTO, UUID id_usuario, UUID id_categoria) {
        Transacao transacao = new Transacao();
        transacao.setCategoria();
        return ;
    }

    @Override
    public String deleteById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
