package repository;

import java.util.List;

import entity.Category;

public interface CategoryRepository {
	public List<Category> findAllCategories();
}
