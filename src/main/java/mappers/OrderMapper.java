package mappers;

import java.util.ArrayList;
import java.util.List;

import dto.OrderData;
import entity.CustomerOrder;

public class OrderMapper {

	public static OrderData mapSingle(CustomerOrder orderModel) {
		OrderData result = new OrderData();

		result.setId(orderModel.getId());
		result.setAmount(orderModel.getAmount());
		result.setDateCreated(orderModel.getDateCreated());
		result.setConfirmationNumber(orderModel.getConfirmationNumber());
		result.setStatus(orderModel.getStatus());

		return result;
	}

	public static List<OrderData> mapCollection(List<CustomerOrder> orderModels) {

		List<OrderData> result = new ArrayList<>();

		for (CustomerOrder orderModel : orderModels) {
			result.add(mapSingle(orderModel));
		}

		return result;
	}
}
