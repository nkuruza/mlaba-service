package za.co.asanda.mlabaservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
public class Player implements Serializable {
	private static final long serialVersionUID = -8678353511986128059L;
	@GeneratedValue
	@Id
	private long id;
	@NotEmpty
	@Column(unique=true)
	private String name;
	@Column(unique=true)
	private String deviceId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
