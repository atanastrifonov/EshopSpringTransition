package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.Category;
import repository.CategoryRepository;

@Component
public class DefaultCategoryService implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category getCategoryById(Short id) {
		return categoryRepository.getCategoryById(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAllCategories();
	}

}
