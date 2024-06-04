package CoinKeeper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CoinKeeper.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{}
