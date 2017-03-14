package se.callista.microservices.core.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.callista.microservices.core.product.model.Price;
import se.callista.microservices.core.product.service.PriceService;

@RestController
public class PriceController {

	@Autowired
	private PriceService priceService;

	@RequestMapping("/price")
	public List<Price> getPrice() {
		return priceService.getAllPrices();
	}

	@RequestMapping("/price/{id}")
	public Price getPriceById(@PathVariable String id) {
		return priceService.getPriceById(id);
	}

	@RequestMapping("/price/geyBysku/{sku}")
	public List<Price> getPriceByName(@PathVariable String skuId) {
		return priceService.getPriceBySku(skuId);
	}

}
