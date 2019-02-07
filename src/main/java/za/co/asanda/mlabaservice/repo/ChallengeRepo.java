package za.co.asanda.mlabaservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.asanda.mlabaservice.model.Challenge;
import za.co.asanda.mlabaservice.model.Game;

public interface ChallengeRepo extends JpaRepository<Challenge, Long> {
	List<Challenge> findByOpponentIdAndGame(long opponentId, Game game);
}
