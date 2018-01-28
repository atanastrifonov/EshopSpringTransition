package forms;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EditProductForm {
	
	@NotNull
	@Size(min=1, max=16, message="{backoffice.name.size.error}")
	private String name;
	
	@NotNull
	@DecimalMin(value = "0.0", message="{backoffice.price.min.error}")
	@DecimalMax(value = "1000.0", message="{backoffice.price.max.error}")
	private BigDecimal price;
	
	@NotNull
	private String description;
	
	@NotNull
	private short categoryId;
	
	@NotNull
	private int productId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(short categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
