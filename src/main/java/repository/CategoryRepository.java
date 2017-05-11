package repository;

import java.util.List;

import entity.Category;

public interface CategoryRepository {
	public Category getCategoryById(Short id);
	public List<Category> findAllCategories();
}
