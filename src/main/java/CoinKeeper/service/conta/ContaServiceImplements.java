package CoinKeeper.service.conta;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CoinKeeper.dto.response.ContaResponseDTO;
import CoinKeeper.model.Conta;
import CoinKeeper.repository.ContaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaServiceImplements implements ContaService{

    @Autowired
    private ContaRepository repository;

    @Override
    public Conta findById(UUID id) {
        return repository.findById(id).get();
    }

    @Override
    public ContaResponseDTO uptadeLimite(UUID id, double valor) {
        Conta conta = repository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada."));
        conta.setSaldo(valor);
        return new ContaResponseDTO(repository.save(conta));

    }
}