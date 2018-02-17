package controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import cart.ShoppingCart;
import dto.ProductData;
import facade.capi.ProductFacade;
import facade.impl.DefaultProductFacade;
import forms.UpdateProductInCartForm;

public class TestCartController {

	private CartController controller;
	private MockMvc mockMvc;
	private ShoppingCart mockCart;

	@Before
	public void setUp() {
		this.controller = new CartController();
		this.mockMvc = standaloneSetup(controller).build();
		this.mockCart = mock(ShoppingCart.class);
	}

	@Test
	public void testViewCart() throws Exception {
		this.mockMvc.perform(get("/viewCart")).andExpect(view().name("cart"));
		this.mockMvc.perform(get("/viewCart").param("clear", "true").sessionAttr("cart", this.mockCart))
				.andExpect(view().name("cart"));

		verify(this.mockCart, times(1)).clear();
	}

	@Test
	public void testAddToCart() throws Exception {
		ProductData expectedProductData = new ProductData();
		expectedProductData.setId(1);
		expectedProductData.setName("Test Product");
		expectedProductData.setDescription("Some description");
		expectedProductData.setCategoryId((short) 2);
		expectedProductData.setPrice(new BigDecimal(123));
		expectedProductData.setLastUpdate(new Date());

		ProductFacade mockProductFacade = mock(DefaultProductFacade.class);
		when(mockProductFacade.getProductById(1)).thenReturn(expectedProductData);

		ReflectionTestUtils.setField(this.controller, "productFacade", mockProductFacade);
		
		this.mockMvc.perform(post("/addToCart").param("productId", "1").sessionAttr("view", "/category/1").sessionAttr("cart", this.mockCart))
				.andExpect(view().name("redirect:/category/1"));
		
		verify(this.mockCart, times(1)).addItem(expectedProductData);
	}
	
	@Test
	public void testUpdateCart() throws Exception{

		this.mockMvc.perform(post("/updateCart")
			.param("productID", "1")
			.param("quantity", "2")
			.sessionAttr("cart", this.mockCart))
				.andExpect(view().name("cart"));
		
		verify(this.mockCart, times(1)).update(1, (short)2);;
	}
}
