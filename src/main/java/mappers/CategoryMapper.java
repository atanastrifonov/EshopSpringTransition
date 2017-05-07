package mappers;

import java.util.ArrayList;
import java.util.List;

import dto.CategoryData;
import entity.Category;

public class CategoryMapper {
	public static List<CategoryData> map(List<Category> categoryEntities) {
		List<CategoryData> result = new ArrayList<>();

		for (Category category : categoryEntities) {
			CategoryData categoryData = new CategoryData();
			categoryData.setName(category.getName());
			result.add(categoryData);
		}

		return result;
	}
}
