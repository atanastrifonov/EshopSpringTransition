package mappers;

import java.util.Collection;

import dto.CategoryProductData;
import dto.ProductData;
import entity.Category;

public class CategoryProductMapper {
	public static CategoryProductData map(Category categoryModel) {

		CategoryProductData result = new CategoryProductData(categoryModel.getId(), categoryModel.getName());
		Collection<ProductData> productDataCollection = ProductMapper
				.mapCollection(categoryModel.getProductCollection());
		result.setAllProducts(productDataCollection);

		return result;
	}
}
