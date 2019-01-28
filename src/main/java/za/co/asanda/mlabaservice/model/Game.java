package za.co.asanda.mlabaservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Game implements Serializable{
	private static final long serialVersionUID = 8866409492298662652L;
	@Id
	@GeneratedValue
	private long id;
	@OneToMany
	private List<Move> moves = new ArrayList<Move>();
	@OneToOne
	private Player player1;
	@OneToOne
	private Player player2;
	@OneToOne
	private Player winner;
	private Date startDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Move> getMoves() {
		return moves;
	}
	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Player getWinner() {
		return winner;
	}
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
