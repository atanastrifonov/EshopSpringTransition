package service.capi;

import entity.CustomerOrder;

public interface EmailService {
	public void sendOrderStatusChangeEmail(CustomerOrder order);
}
