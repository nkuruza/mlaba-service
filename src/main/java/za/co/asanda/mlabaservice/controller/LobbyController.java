package za.co.asanda.mlabaservice.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.asanda.mlabaservice.component.Lobby;
import za.co.asanda.mlabaservice.model.Challenge;
import za.co.asanda.mlabaservice.model.Game;
import za.co.asanda.mlabaservice.model.Player;

@RestController
@RequestMapping("/lobby")
public class LobbyController {
	@Autowired
	private Lobby lobby;
	
	@GetMapping("/join/{id}")
	public void join(@PathVariable("id") long id) {
		lobby.join(id);
	}
	
	@GetMapping("/players")
	public Collection<Player> getPlayers() {
		return lobby.getPlayers();
	}
	@GetMapping("/{me}/challenge/{id}")
	public Challenge challenge(@PathVariable("me") long me, @PathVariable("id") long id) {
		
		return lobby.challenge(me, id);
	}
	@GetMapping("/{me}/accept/{id}")
	public Game accept(@PathVariable("me") long me, @PathVariable("id") long id) {
		return lobby.accept(me, id);
	}
	@GetMapping("/challenges/{id}")
	public List<Challenge> getChallenges(@PathVariable("id") long id){
		List<Challenge> challenges= lobby.getChallenges(id);
		return challenges; 
	}
}
