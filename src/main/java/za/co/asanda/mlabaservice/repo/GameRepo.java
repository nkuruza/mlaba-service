package za.co.asanda.mlabaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.asanda.mlabaservice.model.Game;
import za.co.asanda.mlabaservice.model.Player;

public interface GameRepo extends JpaRepository<Game, Long> {
	Game findByPlayer2IdAndWinner(long playerId, Player winner);
}
