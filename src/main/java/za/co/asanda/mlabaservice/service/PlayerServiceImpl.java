package za.co.asanda.mlabaservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.asanda.mlabaservice.component.Lobby;
import za.co.asanda.mlabaservice.model.Player;
import za.co.asanda.mlabaservice.repo.PlayerRepo;
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepo repo;
	@Autowired
	private Lobby lobby;
	@Override
	public Player addPlayer(Player player) {
		player = repo.save(player);
		lobby.join(player);
		return player;
	}

}
