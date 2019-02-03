package za.co.asanda.mlabaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.asanda.mlabaservice.model.Player;

public interface PlayerRepo extends JpaRepository<Player, Long> {
	Player findByDeviceId(String deviceId);
}
