package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.service;

import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.DTO.RankingDTO;
import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Game;
import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity.Player;
import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.repository.IGameRepo;
import cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.repository.IPlayerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class GameService {
    private final PlayerService playerService;
    private final IGameRepo gameRepo;
    private final IPlayerRepo playerRepo;

    public Object playGame(Long id) {
        Player player = playerService.getPlayerById(id);

        Game game = new Game(player, throwDices());
        gameRepo.save(game);
        return game;
    }

    public String deleteGamesByIdPlayer(Long id) {

        List<Object> objets = gameRepo.findGamesByPlayer_Id(id);
        if (objets.isEmpty() || objets.size() == 0) {
            return "Player with id " + id + " has no games";
        }else {
            objets.stream().forEach(game -> {
                gameRepo.delete((Game) game);
            });
            return "Games deleted";
        }
    }

    public List<Object> getAllGamesByIdPlayer(Long id) {
        return gameRepo.findGamesByPlayer_Id(id);
    }

    public List<RankingDTO> getRankingGames() {
        List<RankingDTO> rankingDTOS = calcRanking();
        return rankingDTOS;
    }

    public String getWinnerRankingPlayer() {
        List<RankingDTO> rankingDTOS = calcRanking();
        if (!rankingDTOS.isEmpty()) {
            //TODO Returns all the best ones with the same ranking.
            return rankingDTOS.stream()
                    .filter(x -> x.getSuccessRate() == rankingDTOS.get(0).getSuccessRate())
                    .toList()
                    .toString();
        }else {
            return "There aren't games";
        }
    }


    public String getLoserRankingPlayer() {
        List<RankingDTO> rankingDTOS = calcRanking();
        if (!rankingDTOS.isEmpty()) {
            //TODO Returns all the worst with the same ranking
            return rankingDTOS.stream()
                    .filter(x -> x.getSuccessRate() == rankingDTOS.get(rankingDTOS.size() - 1).getSuccessRate())
                    .toList()
                    .toString();
        }else {
            return "There aren't games";
        }
    }

    private List<RankingDTO> calcRanking() {
        List<RankingDTO> rankingDTOS = new ArrayList<>();
        List<Player> players = playerRepo.findAll();
        List<Game> games = gameRepo.findAll();
        for (Player player : players) {
            Long id = player.getId();
            int countGameWin = (int) games.stream()
                    .filter(x -> x.getPlayer().getId() == id && x.getPoints() == 7)
                    .count();
            int totalGames = (int) games.stream()
                    .filter(x -> x.getPlayer().getId() == id)
                    .count();
            double successRate = 0.0;
            if (countGameWin > 0) {
                successRate = (double) countGameWin / totalGames;
            }
            // Si un jugador no ha jugado ningún juego, no entra en el ranking
            if (totalGames != 0) {
                RankingDTO rankingDTO = new RankingDTO(player.getId(), player.getName(), countGameWin,
                        totalGames, successRate);
                rankingDTOS.add(rankingDTO);
            }
        }
        // Usando lambda para ordenar la lista en orden descendente según SuccessRate
        rankingDTOS.sort(Comparator.comparing(RankingDTO::getSuccessRate).reversed());
        return rankingDTOS;
    }

    private Integer throwDices() {
        Integer dado1 = new Random().nextInt(6) + 1;
        Integer dado2 = new Random().nextInt(6) + 1;
        return dado1 + dado2;
    }
}
