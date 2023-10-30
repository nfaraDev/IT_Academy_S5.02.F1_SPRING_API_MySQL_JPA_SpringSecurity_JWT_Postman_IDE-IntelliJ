package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.repository;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IPlayerRepo extends JpaRepository<Player,Long> {
    Optional<Player> findPlayerByName(String name);
}

