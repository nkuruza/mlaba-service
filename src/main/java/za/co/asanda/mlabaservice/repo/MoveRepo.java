package za.co.asanda.mlabaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.asanda.mlabaservice.model.Move;

public interface MoveRepo extends JpaRepository<Move, Long> {

}
