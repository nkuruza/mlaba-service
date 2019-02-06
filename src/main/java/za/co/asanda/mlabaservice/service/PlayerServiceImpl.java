package za.co.asanda.mlabaservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.asanda.mlabaservice.model.Player;
import za.co.asanda.mlabaservice.repo.PlayerRepo;
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	@Autowired
	private PlayerRepo repo;
	
	@Override
	public Player addPlayer(Player player) {
		player = repo.save(player);
		return player;
	}
	@Override
	public Player getByDeviceId(String deviceId) {
		return repo.findByDeviceId(deviceId);
	}
}
