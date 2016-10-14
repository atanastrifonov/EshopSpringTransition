package forms;

import javax.validation.constraints.NotNull;

public class ProductToCartForm {
	
	@NotNull
	private String productID;
	
	private String quantity;

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}
