package facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.CategoryData;
import entity.Category;
import mappers.CategoryMapper;
import service.CategoryService;

@Component
public class DefaultCategoryFacade implements CategoryFacade {

	@Autowired
	CategoryService categoryService;
	
	@Override
	public List<CategoryData> getCategories() {
		List<Category> categoryEntities = categoryService.getAllCategories();
		return CategoryMapper.map(categoryEntities);
	}
	
}
