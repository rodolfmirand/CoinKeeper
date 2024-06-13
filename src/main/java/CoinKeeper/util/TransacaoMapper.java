package CoinKeeper.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import CoinKeeper.dto.request.SomaTransacoesRequestDTO;
import CoinKeeper.dto.response.TransacaoResponseDTO;
import CoinKeeper.model.Transacao;
import CoinKeeper.service.CategoriaService;
import CoinKeeper.service.ContaService;

@Component
public class TransacaoMapper {

    @Autowired
    private ContaService contaService;

    @Autowired
    private CategoriaService categoriaService;
    
    public List<TransacaoResponseDTO> toTransacoesResponseDTO(List<Transacao> transacoes){
        return transacoes.stream().map(TransacaoResponseDTO::new).collect(Collectors.toList());
    }

    public Transacao totalRequestToTransacao(SomaTransacoesRequestDTO request) {
        return Transacao.builder()
                .conta(contaService.findById(request.getConta()))
                .categoria(categoriaService.findByIdConta(request.getCategoria()))
                .build();
    }
}