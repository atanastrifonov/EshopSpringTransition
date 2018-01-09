package facade.capi;

import java.util.List;

import dto.CategoryData;
import dto.CategoryProductData;

public interface CategoryFacade {
	public CategoryProductData getCategoryProductById(Short id);
	public List<CategoryData> getAllCategories();
	public List<CategoryData> getStorefrontCategories();
}
