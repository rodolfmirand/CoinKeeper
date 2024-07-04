package CoinKeeper.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CoinKeeper.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}