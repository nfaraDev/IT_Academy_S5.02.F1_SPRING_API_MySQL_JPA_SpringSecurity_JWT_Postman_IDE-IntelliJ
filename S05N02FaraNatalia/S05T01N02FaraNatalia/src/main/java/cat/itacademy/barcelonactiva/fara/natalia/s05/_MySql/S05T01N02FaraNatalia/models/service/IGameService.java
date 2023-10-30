package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.service;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.DTO.RankingDTO;

import java.util.List;

public interface IGameService {
    Object playGame(Long id);
    String deleteGamesByIdPlayer(Long id);
    List<Object> getAllGamesByIdPlayer(Long id);
    List<RankingDTO> getRankingGames();
    public String getWinnerRankingPlayer();


}
