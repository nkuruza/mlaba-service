package za.co.asanda.mlabaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.asanda.mlabaservice.component.GameState;
import za.co.asanda.mlabaservice.model.Game;
import za.co.asanda.mlabaservice.model.Move;

@RestController
@RequestMapping("/game")
public class GameController {
	@Autowired
	private GameState gameState;
	
	@GetMapping("/move")
	public int move(long gameId, Move move) {
		gameState.move(gameId, move);
		return 0;
	}
	@GetMapping("/getLastMove/{id}")
	public Move getLastMove(long gameId) {
		return gameState.getLastMove(gameId);
	}
	@GetMapping("/getPlayerGame/{id}")
	public Game getMyGame(@PathVariable("id") long id) {
		return gameState.getPlayerGame(id);
	}
	@GetMapping("/get/{id}")
	public Game getGame(@PathVariable("id") long id) {
		return gameState.getGame(id);
	}
}
