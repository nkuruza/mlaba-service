package za.co.asanda.mlabaservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Challenge implements Serializable {
	private static final long serialVersionUID = -4242658375802340729L;
	@Id
	@GeneratedValue
	private long id;
	@ManyToOne
	private Player challenger;
	@ManyToOne
	private Player opponent;
	private Date dateCreated;
	private Game game;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Player getChallenger() {
		return challenger;
	}
	public void setChallenger(Player challenger) {
		this.challenger = challenger;
	}
	public Player getOpponent() {
		return opponent;
	}
	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
}
