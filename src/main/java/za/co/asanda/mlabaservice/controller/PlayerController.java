package za.co.asanda.mlabaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.asanda.mlabaservice.model.Player;
import za.co.asanda.mlabaservice.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {
	@Autowired
	private PlayerService service;
	@PostMapping("/add")
	public Player addPlayer(@RequestBody Player player) {
		return service.addPlayer(player);
	}
	@GetMapping("/get/{id}")
	public Player getPlayer(@PathVariable("id") long id) {
		return new Player();
	}
	@GetMapping("/get/by-device/{deviceId}")
	public Player getPlayerByDeviceId(@PathVariable("deviceId") String deviceId) {
		Player player = service.getByDeviceId(deviceId);
		if(player == null)
			player = new Player();
		return player;
	}
}
