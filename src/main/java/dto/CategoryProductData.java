package dto;

import java.util.Collection;

public class CategoryProductData extends CategoryData {
	
	private Collection<ProductData> productCollection;
	
	public CategoryProductData(short id, String name){
		super(id, name);
	}
	
	public Collection<ProductData> getAllProducts(){
		return productCollection;
	}
	
	public void setAllProducts(Collection<ProductData> productCollection){
		this.productCollection = productCollection;
	}
}
