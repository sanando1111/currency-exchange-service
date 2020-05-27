package com.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "exchange_details")
public class ExchangeService {

	public ExchangeService() {
		super();
	}

	@Id
	@Column(name = "exchange_id")
	private Long id;

	public ExchangeService(Long id, String to, String from, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	@Column(name = "exchange_to")
	private String to;
	@Column(name = "exchange_from")
	private String from;
	@Column(name = "exchange_value")
	private BigDecimal conversionMultiple;
	@Column(name = "port")
	private int port;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
