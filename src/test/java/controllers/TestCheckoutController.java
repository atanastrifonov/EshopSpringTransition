package controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import cart.ShoppingCart;
import dto.CustomerData;
import entity.Customer;
import entity.CustomerOrder;
import facade.capi.OrderFacade;
import facade.impl.DefaultOrderFacade;

public class TestCheckoutController {

	private CheckoutController controller;
	private MockMvc mockMvc;
	private ShoppingCart mockCart;

	@Value("${deliverySurcharge}")
	private String surcharge;

	public static final int ORDER_ID = 1;
	public static final int FAILED_ORDER_ID = 0;
	public static final String CUSTOMER_NAME = "John Doe";
	public static final String CUSTOMER_EMAIL = "john.doe@test.com";
	public static final String CUSTOMER_ADDRESS = "Kichuka Hood";
	public static final String CUSTOMER_PHONE = "123123123";
	public static final String CUSTOMER_CITY_REGION = "5";
	public static final String CUSTOMER_CC_NUMBER = "12341234512344";

	@Before
	public void setUp() {
		this.controller = new CheckoutController();
		this.mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		this.mockCart = mock(ShoppingCart.class);
	}

	@Test
	public void testCheckout() throws Exception {
		this.mockMvc.perform(get("/checkout").sessionAttr("cart", this.mockCart)).andExpect(view().name("checkout"))
				.andExpect(model().attributeExists("customerDetailsForm"));

		verify(this.mockCart, times(1)).calculateTotal(surcharge);
	}

	@Test
	public void testPurchase() throws Exception {

		OrderFacade mockOrderFacade = mock(DefaultOrderFacade.class);

		when(mockOrderFacade.placeOrder(Matchers.<CustomerData>anyObject(), eq(this.mockCart))).thenReturn(ORDER_ID);

		Map orderMap = new HashMap();
		orderMap.put("customer", new Customer());
		orderMap.put("lineItems", new ArrayList());
		orderMap.put("orderRecord", new CustomerOrder());
		orderMap.put("orderedProducts", new ArrayList());

		when(mockOrderFacade.getOrderDetails(ORDER_ID)).thenReturn(orderMap);

		ReflectionTestUtils.setField(this.controller, "orderFacade", mockOrderFacade);

		//happy case
		this.mockMvc.perform(post("/purchase")
				.param("name", CUSTOMER_NAME)
				.param("email", CUSTOMER_EMAIL)
				.param("phone", CUSTOMER_PHONE)
				.param("address", CUSTOMER_ADDRESS)
				.param("cityRegion", CUSTOMER_CITY_REGION)
				.param("ccNumber", CUSTOMER_CC_NUMBER).sessionAttr("cart", this.mockCart))
		.andExpect(view().name("confirmation"))
		.andExpect(model().attributeExists("customer", "lineItems", "orderRecord", "orderedProducts"))
		.andExpect(model().attribute("customer", orderMap.get("customer")))
		.andExpect(model().attribute("lineItems", orderMap.get("lineItems")))
		.andExpect(model().attribute("orderRecord", orderMap.get("orderRecord")))
		.andExpect(model().attribute("orderedProducts", orderMap.get("orderedProducts")));
		
		when(mockOrderFacade.placeOrder(Matchers.<CustomerData>anyObject(), eq(this.mockCart))).thenReturn(FAILED_ORDER_ID);
		
		//error case
		this.mockMvc.perform(post("/purchase")
				.param("name", CUSTOMER_NAME)
				.param("email", CUSTOMER_EMAIL)
				.param("phone", CUSTOMER_PHONE)
				.param("address", CUSTOMER_ADDRESS)
				.param("cityRegion", CUSTOMER_CITY_REGION)
				.param("ccNumber", CUSTOMER_CC_NUMBER).sessionAttr("cart", this.mockCart))
		.andExpect(view().name("checkout"))
		.andExpect(model().attributeExists("orderFailureFlag"))
		.andExpect(model().attribute("orderFailureFlag", true));
		
		
		//weird case
		this.mockMvc.perform(post("/purchase")
				.param("name", CUSTOMER_NAME)
				.param("email", CUSTOMER_EMAIL)
				.param("phone", CUSTOMER_PHONE)
				.param("address", CUSTOMER_ADDRESS)
				.param("cityRegion", CUSTOMER_CITY_REGION)
				.param("ccNumber", CUSTOMER_CC_NUMBER))
		.andExpect(view().name("home"));
	}
}
