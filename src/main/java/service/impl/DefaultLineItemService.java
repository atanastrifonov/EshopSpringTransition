package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.LineItem;
import repository.capi.LineItemRepository;
import service.capi.LineItemService;

@Component
public class DefaultLineItemService implements LineItemService {

	@Autowired
	LineItemRepository lineItemRepository;
	
	@Override
	public LineItem getLineItemById(Integer id) {
		return lineItemRepository.getLineItemById(id);
	}

	@Override
	public void addLineItem(LineItem lineItemModel) {
		lineItemRepository.addLineItem(lineItemModel);
	}

}
