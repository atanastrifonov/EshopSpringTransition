package facade.capi;

import dto.ProductData;

public interface ProductFacade {
	public ProductData getProductById(Integer id);
	public void updateProduct(ProductData productData);
}
