package service.capi;

import java.util.List;
import entity.Category;

public interface CategoryService {
	public Category getCategoryById(Short id);
	public List<Category> getAllCategories();
}
