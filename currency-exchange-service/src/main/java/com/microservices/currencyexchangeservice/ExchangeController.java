package com.microservices.currencyexchangeservice;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

	@Autowired
	private Environment env;

	@Autowired
	private ExchangeDataDao exchangeDao;

	@GetMapping("/conversion/{to}/exchange/{from}")
	public ExchangeService getExchangeDetails(@PathVariable String to, @PathVariable String from) {
		/*
		 * return new ExchangeService(1000L, "INR", "USD", new BigDecimal(70),
		 * Integer.parseInt(env.getProperty("server.port")));
		 */
		int port = Integer.parseInt(env.getProperty("server.port"));
		ExchangeService model=exchangeDao.getExchangeDetails(to, from);
		model.setPort(port);
		return model;
	}

	@GetMapping("/exchange/data/all")
	public List<ExchangeService> getAllExchangeDetails() {
		int port = Integer.parseInt(env.getProperty("server.port"));

		List<ExchangeService> exchangeInfoList = exchangeDao.getExchangeData();
		for (ExchangeService service : exchangeInfoList) {
			service.setPort(port);
		}

		return exchangeInfoList;
	}

}
