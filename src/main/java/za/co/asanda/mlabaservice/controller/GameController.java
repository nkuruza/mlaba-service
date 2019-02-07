package za.co.asanda.mlabaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/move/{gameId}")
	public Move move(@PathVariable("gameId") long gameId, @RequestBody Move move) {
		return gameState.move(gameId, move);
	}
	@GetMapping("/getLastMove/{id}")
	public Move getLastMove(@PathVariable("id") long gameId) {
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
	@GetMapping("/get/game/creator/{id}")
	public Game getGameByPlayer1(@PathVariable("id") long id) {
		return gameState.getGameByPlayer1(id);
	}
	@GetMapping("{id}/set/winner/{playerId}")
	public Game setWinner(@PathVariable("id") long gameId, @PathVariable("playerId") long playerId) {
		return gameState.setWinner(gameId, playerId);
	}
}
