package CoinKeeper.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import CoinKeeper.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

}
