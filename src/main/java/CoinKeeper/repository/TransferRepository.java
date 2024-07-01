package CoinKeeper.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import CoinKeeper.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {

}
