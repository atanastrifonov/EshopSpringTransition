package service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cart.ShoppingCart;
import cart.ShoppingCartItem;
import entity.Customer;
import entity.CustomerOrder;
import entity.LineItem;
import entity.OrderedProduct;
import entity.OrderedProductPK;
import entity.Product;
import mappers.LineItemMapper;
import repository.capi.CustomerOrderRepository;
import repository.capi.LineItemRepository;
import repository.capi.OrderedProductRepository;
import repository.capi.ProductRepository;
import service.capi.CustomerService;
import service.capi.EmailService;
import service.capi.OrderService;

@Component
public class DefaultOrderService implements OrderService {

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerOrderRepository customerOrderRepository;

	@Autowired
	OrderedProductRepository orderedProductRepository;

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	LineItemRepository lineItemRepository;

	@Override
	@Transactional
	public int placeOrder(Customer customer, ShoppingCart cart) {
		try {
			customerService.addCustomer(customer);
			CustomerOrder order = addOrder(customer, cart);
			addOrderedItems(order, cart);

			return order.getId();
		} catch (Exception e) {
			return 0;
		}
	}

	private CustomerOrder addOrder(Customer customer, ShoppingCart cart) {
		// set up customer order
		CustomerOrder order = new CustomerOrder();
		order.setCustomerId(customer);
		order.setAmount(BigDecimal.valueOf(cart.getTotal()));

		// create confirmation number
		Random random = new Random();
		int i = random.nextInt(999999999);
		order.setConfirmationNumber(i);
		order.setStatus("NEW");

		customerOrderRepository.addOrder(order);
		return order;
	}

	private void addOrderedItems(CustomerOrder order, ShoppingCart cart) {
		List<ShoppingCartItem> items = cart.getItems();

		// iterate through shopping cart and create OrderedProducts
		for (ShoppingCartItem scItem : items) {

			int lineItemId = lineItemRepository.addLineItem(LineItemMapper.mapSingle(scItem.getProduct()));

			// set up primary key object
			OrderedProductPK orderedProductPK = new OrderedProductPK();
			orderedProductPK.setCustomerOrderId(order.getId());
			orderedProductPK.setLineItemId(lineItemId);

			// CONSTRAINT VIOLATION EXCEPTION TRIGGER TEST!!!
			// orderedProductPK.setCustomerOrderId(1);
			// orderedProductPK.setProductId(1);
			// CONSTRAINT VIOLATION EXCEPTION TRIGGER TEST!!!

			// create ordered item using PK object
			OrderedProduct orderedItem = new OrderedProduct(orderedProductPK);

			// set quantity
			orderedItem.setQuantity(scItem.getQuantity());

			orderedProductRepository.addOrderedProduct(orderedItem);
		}

	}

	@Override
	public Map getOrderDetails(int orderId) {

		Map orderMap = new HashMap();

		// get order
		CustomerOrder order = customerOrderRepository.getOrderById(orderId);

		// get customer
		Customer customer = order.getCustomerId();

		// get all ordered products
		List<OrderedProduct> orderedProducts = orderedProductRepository.findAllByOrderId(orderId);

		// get product details for ordered items
		List<LineItem> lineItems = new ArrayList<LineItem>();

		for (OrderedProduct op : orderedProducts) {

			LineItem li = (LineItem) lineItemRepository.getLineItemById(op.getOrderedProductPK().getLineItemId());
			lineItems.add(li);
		}

		// add each item to orderMap
		orderMap.put("orderRecord", order);
		orderMap.put("customer", customer);
		orderMap.put("orderedProducts", orderedProducts);
		orderMap.put("lineItems", lineItems);

		return orderMap;
	}

	@Override
	public List<CustomerOrder> getAllPendingOrders() {
		return customerOrderRepository.getAllPendingOrders();
	}

	@Override
	public void updateOrder(int orderId, String status) {
		CustomerOrder order = customerOrderRepository.getOrderById(orderId);
		order.setStatus(status);
		customerOrderRepository.updateOrder(order);
		// TODO: uncomment the following line when email sending is needed
		//emailService.sendOrderStatusChangeEmail(order);
	}

}
