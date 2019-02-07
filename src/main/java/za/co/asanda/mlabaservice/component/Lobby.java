package za.co.asanda.mlabaservice.component;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.asanda.mlabaservice.model.Challenge;
import za.co.asanda.mlabaservice.model.Game;
import za.co.asanda.mlabaservice.model.Player;
import za.co.asanda.mlabaservice.repo.ChallengeRepo;
import za.co.asanda.mlabaservice.repo.PlayerRepo;

@Component("lobby")
public class Lobby {
	@Autowired
	private ChallengeRepo challengeRepo;
	@Autowired 
	private PlayerRepo playerRepo;
	@Autowired
	private GameState gameState;
	
	private Map<Long, Player> players = new HashMap<Long, Player>();
	private void join(Player player) {
		players.put(player.getId(), player);
	}
	public Challenge challenge(long challengerId, long opponentId) {
		Challenge c = new Challenge();
		c.setChallenger(playerRepo.getOne(challengerId));
		c.setOpponent(playerRepo.getOne(opponentId));
		c.setDateCreated(new Date());
		c = challengeRepo.save(c);
		return c;
	}
	public Game accept(long opponentId, long challengeId) {
		Challenge challenge = challengeRepo.getOne(challengeId);
		if(challenge.getOpponent().getId() != opponentId || challenge.getGame() != null)
			return null;
		Game game = gameState.startGame(challenge.getOpponent(), challenge.getChallenger());
		challenge.setGame(game);
		challengeRepo.save(challenge);
		players.remove(opponentId);
		players.remove(challenge.getChallenger().getId());
		return game;
	}
	public Collection<Player> getPlayers(){
		return this.players.values();
	}
	public List<Challenge> getChallenges(long playerId){
		return challengeRepo.findByOpponentIdAndGame(playerId, null);
	}
	public void join(long id) {
		Player player = playerRepo.getOne(id);
		join(player);		
	}
}
