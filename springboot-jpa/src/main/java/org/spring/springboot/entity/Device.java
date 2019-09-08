package org.spring.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 城市实体类
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Entity
public class Device implements Serializable {

	private static final long serialVersionUID = -1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "request", nullable = true, length = 12)
	private String request;//register
	@Column(name = "uuid", nullable = true, length = 32)
	private String uuid;//cd33-977e-c809-e03a
	@Column(name = "brand", nullable = true, length = 15)
	private String brand;//jsrz
	@Column(name = "app", nullable = true, length = 12)
	private String app;//icast
	@Column(name = "model", nullable = true, length = 12)
	private String model;//t9wan
	@Column(name = "version", nullable = true, length = 12)
	private String version;//5.1.1

	public Long getId() {
		return id;
	}

	public Device setId(Long id) {
		this.id = id;
		return this;
	}

	public String getRequest() {
		return request;
	}

	public Device setRequest(String request) {
		this.request = request;
		return this;
	}

	public String getUuid() {
		return uuid;
	}

	public Device setUuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	public String getBrand() {
		return brand;
	}

	public Device setBrand(String brand) {
		this.brand = brand;
		return this;
	}

	public String getApp() {
		return app;
	}

	public Device setApp(String app) {
		this.app = app;
		return this;
	}

	public String getModel() {
		return model;
	}

	public Device setModel(String model) {
		this.model = model;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public Device setVersion(String version) {
		this.version = version;
		return this;
	}


	@Override
	public String toString() {
		return "Device{" +
				"id=" + id +
				", request='" + request + '\'' +
				", uuid='" + uuid + '\'' +
				", brand='" + brand + '\'' +
				", app='" + app + '\'' +
				", model='" + model + '\'' +
				", version='" + version + '\'' +
				'}';
	}
}
