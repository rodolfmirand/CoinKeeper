package CoinKeeper.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CoinKeeper.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
