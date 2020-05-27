package com.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeServiceRepository extends JpaRepository<ExchangeService, Long> {
	
	public ExchangeService findByToAndFrom(String to,String from);

}
