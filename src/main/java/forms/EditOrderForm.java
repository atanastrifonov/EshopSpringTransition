package forms;

import javax.validation.constraints.NotNull;

public class EditOrderForm {

	@NotNull
	private String status;

	@NotNull
	private int orderId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
