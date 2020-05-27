package com.microservices.currencyexchangeservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExchangeDataDao {

	@Autowired
	private ExchangeServiceRepository repository;

	public List<ExchangeService> getExchangeData() {

		List<ExchangeService> exchangeList = repository.findAll();
		System.out.println("Fetched record:" + exchangeList.size());
		return exchangeList;
	}

	public ExchangeService getExchangeDetails(String to, String from) {
		return repository.findByToAndFrom(to, from);
	}

}
