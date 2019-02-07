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
import za.co.asanda.mlabaservice.repo.MoveRepo;

@Component("game")
public class GameState {
	@Autowired
	private GameRepo gameRepo;
	@Autowired
	private MoveRepo moveRepo;
	
	private Map<Long, Game> games = new HashMap<Long, Game>();
	
	public Game startGame(Player player1, Player player2) {
		Game game = new Game();
		game.setPlayer1(player1);
		game.setPlayer2(player2);
		game.setStartDate(new Date());
		gameRepo.save(game);
		return game;
	}
	public Move move(long gameId, Move move) {
		Game game = games.get(gameId);
		if(game == null) {
			game = gameRepo.getOne(gameId);
			games.put(gameId, game);
		}
		
		games.get(gameId).getMoves().add(move);
		moveRepo.save(move);
		return move;
	}
	public Move getLastMove(long gameId) {
		List<Move> moves = games.get(gameId).getMoves();
		int numMoves = moves.size();
		return numMoves > 0 ? moves.get(numMoves - 1) : new Move();
	}
	public Game getPlayerGame(long id) {
		Game game = gameRepo.findByPlayer2IdAndWinner(id, null);
		if(game != null && games.get(game.getId()) == null)
			games.put(game.getId(), game);
		if (game == null)
			game = getGameByPlayer1(id);
		return game;
	}
	public Game setWinner(long gameId, long playerId) {
		Game game = getGame(gameId);
		game.setWinner(game.getPlayer1().getId() == playerId ? game.getPlayer1() : game.getPlayer2());
		return gameRepo.save(game);
	}
	public Game getGame(long id) {
		Game g = games.get(id);
		if(g == null)
			g = gameRepo.getOne(id);
		return g;
	}
	public Game getGameByPlayer1(long id) {
		Game game = gameRepo.findByPlayer1IdAndWinner(id, null);
		return game != null ? game : new Game();
	}

}
