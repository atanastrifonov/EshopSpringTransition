package repository.capi;

import entity.LineItem;

public interface LineItemRepository {
	public LineItem getLineItemById(Integer id);
	public int addLineItem(LineItem lineItem);
}
