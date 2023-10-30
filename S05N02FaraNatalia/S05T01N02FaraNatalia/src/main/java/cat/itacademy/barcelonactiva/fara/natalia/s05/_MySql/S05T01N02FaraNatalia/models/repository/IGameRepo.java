package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.repository;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGameRepo extends JpaRepository<Game,Long> {
    List<Game> findAllByPlayerId(Long id);

    List<Object> findGamesByPlayer_Id (Long playerId);

}

