package repository;

import java.util.List;

import entity.Category;

public interface TestRepository {
	public List<Category> findAllCategories();
}
