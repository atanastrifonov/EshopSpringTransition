package mappers;

import java.util.ArrayList;
import java.util.Collection;

import dto.ProductData;
import entity.Category;
import entity.Product;

public class ProductMapper {

	public static ProductData mapSingle(Product productModel) {
		ProductData result = new ProductData();

		result.setId(productModel.getId());
		result.setName(productModel.getName());
		result.setDescription(productModel.getDescription());
		result.setLastUpdate(productModel.getLastUpdate());
		result.setPrice(productModel.getPrice());
		result.setCategoryId(productModel.getCategoryId().getId());

		return result;
	}

	public static Collection<ProductData> mapCollection(Collection<Product> productModels) {

		Collection<ProductData> result = new ArrayList<>();

		for (Product productModel : productModels) {
			result.add(ProductMapper.mapSingle(productModel));
		}

		return result;
	}
	
	public static Product mapSingle(ProductData productData, Category categoryModel){
		Product productModel = new Product();
		
		productModel.setId(productData.getId());
		productModel.setName(productData.getName());
		productModel.setDescription(productData.getDescription());
		productModel.setPrice(productData.getPrice());
		productModel.setLastUpdate(productData.getLastUpdate());
		productModel.setCategoryId(categoryModel);
		
		return productModel;
	}
}
