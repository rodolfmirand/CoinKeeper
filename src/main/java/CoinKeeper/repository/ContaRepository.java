package CoinKeeper.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CoinKeeper.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, UUID> {
}