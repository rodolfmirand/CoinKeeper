package CoinKeeper.service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.request.TransacaoRequestDTO;
import CoinKeeper.dto.response.TransacaoResponseDTO;
import CoinKeeper.model.Categoria;
import CoinKeeper.model.Conta;
import CoinKeeper.model.Transacao;
import CoinKeeper.repository.CategoriaRepository;
import CoinKeeper.repository.ContaRepository;
import CoinKeeper.repository.TransacaoRepository;
import CoinKeeper.util.TransacaoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransacaoServiceImplements implements TransacaoService {

    @Autowired
    private final TransacaoRepository transacaoRepository;

    @Autowired
    private final CategoriaRepository categoriaRepository;

    @Autowired
    private final ContaRepository contaRepository;

    private final TransacaoMapper transacaoMapper;

    @Override
    public List<TransacaoResponseDTO> findAll() {
        return transacaoMapper.toTransacoesResponseDTO(transacaoRepository.findAll());
    }

    @Override
    public TransacaoResponseDTO register(TransacaoRequestDTO transacaoRequestDTO) {
        Transacao transacao = new Transacao();
        transacao.setConta(searchConta(transacaoRequestDTO.getConta()));
        transacao.setValor(transacaoRequestDTO.getValor());
        transacao.setCategoria(searchCategoria(transacaoRequestDTO.getCategoria()));
        transacao.setData(LocalDate.now());
        transacao.setTipo(transacao.getCategoria().getNome());

        Conta conta = transacao.getConta();
        double responseUpdateSaldo = conta.updateSaldo(transacao.getValor());

        if (responseUpdateSaldo == -1)
            return null;

        transacaoRepository.save(transacao);
        contaRepository.save(conta);

        return new TransacaoResponseDTO(transacao);
    }

    @Override
    public String deleteById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    private Categoria searchCategoria(UUID id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    private Conta searchConta(UUID id) {
        return contaRepository.findById(id).orElse(null);
    }
}
