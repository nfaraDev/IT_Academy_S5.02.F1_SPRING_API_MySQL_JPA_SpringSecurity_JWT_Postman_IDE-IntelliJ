package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.service;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.DTO.PlayerDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Player;

public interface IPlayerService {
    PlayerDTO createPlayer(PlayerDTO playerDTO);

    Object updatePlayer(Long id, PlayerDTO playerDTO);

    Player getPlayerById(Long id);
}
