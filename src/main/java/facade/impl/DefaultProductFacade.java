package facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.ProductData;
import entity.Product;
import facade.capi.ProductFacade;
import mappers.ProductMapper;
import service.capi.ProductService;

@Component
public class DefaultProductFacade implements ProductFacade{

	@Autowired
	ProductService productService;
	
	@Override
	public ProductData getProductById(Integer id) {
		Product productModel = productService.getProductById(id);
		return ProductMapper.mapSingle(productModel);
	}

}
