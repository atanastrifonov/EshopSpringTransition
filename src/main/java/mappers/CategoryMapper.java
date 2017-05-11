package mappers;

import java.util.ArrayList;
import java.util.List;

import dto.CategoryData;
import entity.Category;

public class CategoryMapper {
	
	public static CategoryData mapSingle(Category categoryModel) {
		CategoryData categoryData = new CategoryData();
		
		categoryData.setId(categoryModel.getId());
		categoryData.setName(categoryModel.getName());
		
		return categoryData;
	}

	public static List<CategoryData> mapCollection(List<Category> categoryModels) {
		List<CategoryData> result = new ArrayList<>();

		for (Category categoryModel : categoryModels) {
			result.add(mapSingle(categoryModel));
		}

		return result;
	}
}
