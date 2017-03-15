package se.callista.microservices.core.product.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.callista.microservices.core.product.dao.PriceRepository;
import se.callista.microservices.core.product.model.Price;

@Service
@Transactional
public class PriceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PriceService.class);
	public static final String priceName = "created";
	@Autowired
	private PriceRepository priceRepository;
	@Cacheable(value = "prices")
	public List<Price> getAllPrices() {
		LOGGER.info("fetching all prices");
		List<Price> products = new ArrayList<>();
		priceRepository.findAll().forEach(products::add);
		return products;
	}
	@Cacheable(value = "prices", key = "#id")
	public Price getPriceById(String id) {
		LOGGER.info("fetching price for id" + id);
		return priceRepository.findOne(id);
	}

	public List<Price> getPriceBySku(String skuId) {
		return priceRepository.findBySkuId(skuId);
	}

	

}
