package mappers;

import dto.ProductData;
import entity.LineItem;

public class LineItemMapper {
	
	public static LineItem mapSingle(ProductData productData) {
		LineItem result = new LineItem();

		result.setName(productData.getName());
		result.setPrice(productData.getPrice());
		result.setDescription(productData.getDescription());
		result.setLastUpdate(productData.getLastUpdate());
		
		return result;
	}
}
