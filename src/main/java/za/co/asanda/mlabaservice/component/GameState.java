package za.co.asanda.mlabaservice.component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.asanda.mlabaservice.model.Game;
import za.co.asanda.mlabaservice.model.Move;
import za.co.asanda.mlabaservice.model.Player;
import za.co.asanda.mlabaservice.repo.GameRepo;

@Component("game")
public class GameState {
	@Autowired
	private GameRepo gameRepo;
	
	private Map<Long, Game> games = new HashMap<Long, Game>();
	
	public Game startGame(Player player1, Player player2) {
		Game game = new Game();
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setStartDate(new Date());
		gameRepo.save(game);
		return game;
	}
	public int move(long gameId, Move move) {
		Game game = games.get(gameId);
		if(game == null) {
			game = gameRepo.getOne(gameId);
			games.put(gameId, game);
		}
			
		List<Move> moves = game.getMoves();
		int numMoves = moves.size();
		games.get(gameId).getMoves().add(move);
		return numMoves - game.getMoves().size();
	}
	public Move getLastMove(long gameId) {
		List<Move> moves = games.get(gameId).getMoves();
		int numMoves = moves.size();
		return numMoves > 0 ? moves.get(numMoves - 1) : null;
	}
	public Game getPlayerGame(long id) {
		Game game = gameRepo.findByPlayer2IdAndWinner(id, null);
		if(games.get(game.getId()) == null)
			games.put(game.getId(), game);
		return game;
	}
	public Game getGame(long id) {
		return gameRepo.getOne(id);
	}

}
