package cat.itacademy.barcelonactiva.fara.natalia.s05._MySql.S05T01N02FaraNatalia.models.domainEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer points;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Game(Player player, Integer points) {
        this.player = player;
        this.points = points;
    }

    @Override
    public String toString() {
        return player  +
                "You've got " + points + " points " + " " +
                ((points == 7) ? " You WIN!!!!" : " You LOST!!!")
                + "\n";

    }


}
