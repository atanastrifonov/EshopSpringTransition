package controllers.backoffice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import dto.OrderData;
import entity.Customer;
import entity.CustomerOrder;
import facade.capi.OrderFacade;
import facade.impl.DefaultOrderFacade;

public class TestOrdersController {
	
	private OrdersController controller;
	private MockMvc mockMvc;
	OrderFacade mockOrderFacade;
	
	public static final int ORDER_ID = 1;
	public static final String STATUS_ACCEPTED = "ACCEPTED";
	
	@Before
	public void setUp(){
		this.controller = new OrdersController();
		this.mockMvc = standaloneSetup(controller).build();
		this.mockOrderFacade = mock(DefaultOrderFacade.class);
	}
	
	@Test
	public void testViewPendingOrders() throws Exception{
		when(this.mockOrderFacade.getAllPendingOrders()).thenReturn(new ArrayList<OrderData>());
		
		ReflectionTestUtils.setField(this.controller, "orderFacade", mockOrderFacade);
		
		this.mockMvc.perform(get("/backoffice/orders/pending"))
			.andExpect(view().name("admin/pendingOrders"))
			.andExpect(model().attributeExists("pendingOrders"));
	}
	
	@Test
	public void testViewSingleOrder() throws Exception{
		Map orderMap = new HashMap();
		orderMap.put("customer", new Customer());
		orderMap.put("lineItems", new ArrayList());
		orderMap.put("orderRecord", new CustomerOrder());
		orderMap.put("orderedProducts", new ArrayList());

		when(mockOrderFacade.getOrderDetails(ORDER_ID)).thenReturn(orderMap);

		ReflectionTestUtils.setField(this.controller, "orderFacade", mockOrderFacade);
		
		this.mockMvc.perform(get("/backoffice/orders/" + ORDER_ID))
		.andExpect(view().name("admin/editOrder"))
		.andExpect(model().attributeExists("customer", "lineItems", "orderRecord", "editOrderForm"))
		.andExpect(model().attribute("customer", orderMap.get("customer")))
		.andExpect(model().attribute("lineItems", orderMap.get("lineItems")))
		.andExpect(model().attribute("orderRecord", orderMap.get("orderRecord")));
	}
	
	@Test
	public void testEditSingleOrder() throws Exception{
		ReflectionTestUtils.setField(this.controller, "orderFacade", mockOrderFacade);
		
		//happy case
		this.mockMvc.perform(post("/backoffice/orders//editOrder")
				.param("status", STATUS_ACCEPTED)
				.param("orderId", Integer.toString(ORDER_ID)))
		.andExpect(view().name("redirect:/backoffice/orders/" + ORDER_ID))
		.andExpect(flash().attributeExists("isUpdateSuccessful"))
		.andExpect(flash().attribute("isUpdateSuccessful", true));
		
		verify(this.mockOrderFacade, times(1)).updateOrder(ORDER_ID, STATUS_ACCEPTED);;
		
		//error case
		this.mockMvc.perform(post("/backoffice/orders//editOrder")
				.param("orderId", Integer.toString(0)))
		.andExpect(view().name("redirect:/backoffice/orders/" + 0))
		.andExpect(flash().attributeExists("hasErrors"))
		.andExpect(flash().attribute("hasErrors", true));
	}
}
