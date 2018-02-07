package service.capi;

import entity.LineItem;

public interface LineItemService {
	public LineItem getLineItemById(Integer id);
	public void addLineItem(LineItem lineItemModel);
}
