package se.callista.microservices.core.product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import se.callista.microservices.core.product.model.Price;

public interface PriceRepository extends CrudRepository<Price, String> {
	public List<Price> findBySkuId(String skuId);
}