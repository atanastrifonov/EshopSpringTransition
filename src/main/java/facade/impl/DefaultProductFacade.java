package facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.ProductData;
import entity.Category;
import entity.Product;
import facade.capi.ProductFacade;
import mappers.ProductMapper;
import service.capi.CategoryService;
import service.capi.ProductService;

@Component
public class DefaultProductFacade implements ProductFacade{

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Override
	public ProductData getProductById(Integer id) {
		Product productModel = productService.getProductById(id);
		return ProductMapper.mapSingle(productModel);
	}

	@Override
	public void updateProduct(ProductData productData) {
		Category categoryModel = categoryService.getCategoryById(productData.getCategoryId());
		Product productModel =  ProductMapper.mapSingle(productData, categoryModel);
		
		productService.updateProduct(productModel);
	}
}
