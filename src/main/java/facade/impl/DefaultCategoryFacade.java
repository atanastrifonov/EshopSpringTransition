package facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dto.CategoryData;
import dto.CategoryProductData;
import entity.Category;
import facade.capi.CategoryFacade;
import mappers.CategoryMapper;
import mappers.CategoryProductMapper;
import service.capi.CategoryService;

@Component
public class DefaultCategoryFacade implements CategoryFacade {

	@Autowired
	CategoryService categoryService;

	@Override
	public CategoryProductData getCategoryProductById(Short id) {
		Category categoryModel = categoryService.getCategoryById(id);
		return CategoryProductMapper.map(categoryModel);
	}

	@Override
	public List<CategoryData> getCategories() {
		List<Category> categoryModels = categoryService.getAllCategories();
		return CategoryMapper.mapCollection(categoryModels);
	}

}
