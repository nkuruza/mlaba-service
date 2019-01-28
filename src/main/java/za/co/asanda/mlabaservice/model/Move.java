package za.co.asanda.mlabaservice.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
@Entity
public class Move implements Serializable {
	private static final long serialVersionUID = -3542037986520837493L;
	@Id
	@GeneratedValue
	private long id;
	private Integer srcx;
	private Integer srcy;
	@NotNull
	private Integer dstx;
	@NotNull
	private Integer dsty;
	
	private Integer prix;
	private Integer priy;
	
	private Date timestamp;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Integer getSrcx() {
		return srcx;
	}
	public void setSrcx(Integer srcx) {
		this.srcx = srcx;
	}
	public Integer getSrcy() {
		return srcy;
	}
	public void setSrcy(Integer srcy) {
		this.srcy = srcy;
	}
	public Integer getDstx() {
		return dstx;
	}
	public void setDstx(Integer dstx) {
		this.dstx = dstx;
	}
	public Integer getDsty() {
		return dsty;
	}
	public void setDsty(Integer dsty) {
		this.dsty = dsty;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	public Integer getPriy() {
		return priy;
	}
	public void setPriy(Integer priy) {
		this.priy = priy;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
