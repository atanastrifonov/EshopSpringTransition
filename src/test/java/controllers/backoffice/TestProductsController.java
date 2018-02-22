package controllers.backoffice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.mockito.Matchers.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;import org.springframework.test.web.servlet.result.FlashAttributeResultMatchers;

import dto.CategoryData;
import dto.CategoryProductData;
import dto.CustomerData;
import dto.ProductData;
import facade.capi.CategoryFacade;
import facade.capi.ProductFacade;
import facade.impl.DefaultCategoryFacade;
import facade.impl.DefaultProductFacade;

public class TestProductsController {

	private ProductsController controller;
	private MockMvc mockMvc;
	private CategoryFacade categoryFacadeMock;
	private ProductFacade productsFacadeMock;

	public static final String CATEGORY_ID = "1";
	public static final String CATEGORY_NAME = "Food";
	public static final int PRODUCT_ID = 1;
	public static final String PRODUCT_NAME = "Beef fillet";
	public static final BigDecimal PRODUCT_PRICE = new BigDecimal(123.22);
	public static final String PRODUCT_DESCRIPTION = "The best quality beef on the market";
	public static final Date PRODUCT_LAST_UPDATE = new Date();
	public static final Short PRODUCT_CATEGORY_ID = 1;

	@Before
	public void setUp() {
		this.controller = new ProductsController();
		this.mockMvc = standaloneSetup(controller).build();
		this.categoryFacadeMock = mock(DefaultCategoryFacade.class);
		this.productsFacadeMock = mock(DefaultProductFacade.class);
	}

	@Test
	public void testViewProductsLanding() throws Exception {
		when(this.categoryFacadeMock.getAllCategories()).thenReturn(new ArrayList<CategoryData>());

		ReflectionTestUtils.setField(this.controller, "categoryFacade", this.categoryFacadeMock);

		this.mockMvc.perform(get("/backoffice/products")).andExpect(view().name("admin/manageProductsLanding"))
				.andExpect(model().attributeExists("categories"));
		
		verify(this.categoryFacadeMock, times(1)).getAllCategories();
	}

	@Test
	public void testViewCategoryProducts() throws Exception {
		when(this.categoryFacadeMock.getCategoryProductById(Short.parseShort(CATEGORY_ID)))
				.thenReturn(new CategoryProductData(Short.parseShort(CATEGORY_ID), CATEGORY_NAME));
		
		ReflectionTestUtils.setField(this.controller, "categoryFacade", this.categoryFacadeMock);
		
		this.mockMvc.perform(get("/backoffice/products/chooseCategory").param("categoryId", CATEGORY_ID))
		.andExpect(view().name("admin/categoryProductsListing"))
		.andExpect(model().attributeExists("selectedCategory"));
		
		verify(this.categoryFacadeMock, times(1)).getCategoryProductById(Short.parseShort(CATEGORY_ID));
	}

	@Test
	public void testViewSingleProduct() throws Exception{
		ProductData productData = new ProductData();
		productData.setId(PRODUCT_ID);
		productData.setName(PRODUCT_NAME);
		productData.setPrice(PRODUCT_PRICE);
		productData.setDescription(PRODUCT_DESCRIPTION);
		productData.setLastUpdate(PRODUCT_LAST_UPDATE);
		productData.setCategoryId(PRODUCT_CATEGORY_ID);
		
		when(this.productsFacadeMock.getProductById(PRODUCT_ID)).thenReturn(productData);
		when(this.categoryFacadeMock.getAllCategories()).thenReturn(new ArrayList<CategoryData>());
		
		ReflectionTestUtils.setField(this.controller, "categoryFacade", this.categoryFacadeMock);
		ReflectionTestUtils.setField(controller, "productFacade", this.productsFacadeMock);
		
		this.mockMvc.perform(get("/backoffice/products/" + PRODUCT_ID))
			.andExpect(view().name("admin/editProduct"))
			.andExpect(model().attributeExists("editProductForm", "categories"));
		
		verify(this.productsFacadeMock, times(1)).getProductById(PRODUCT_ID);
		verify(this.categoryFacadeMock, times(1)).getAllCategories();
	}
	
	@Test
	public void testEditSingleProduct() throws Exception{
		ReflectionTestUtils.setField(controller, "productFacade", this.productsFacadeMock);
		
		//happy case
		this.mockMvc.perform(post("/backoffice/products/editProduct")
				.param("productId", Integer.toString(PRODUCT_ID))
				.param("name", PRODUCT_NAME)
				.param("price", PRODUCT_PRICE.toString())
				.param("description", PRODUCT_DESCRIPTION)
				.param("categoryId", PRODUCT_CATEGORY_ID.toString())
				)
		.andExpect(view().name("redirect:/backoffice/products/" + PRODUCT_ID))
		.andExpect(flash().attributeExists("isUpdateSuccessful"))
		.andExpect(flash().attribute("isUpdateSuccessful", true));
		
		verify(this.productsFacadeMock, times(1)).updateProduct(Matchers.<ProductData>anyObject());
		
		//error case - EditProductForm validation fail
		this.mockMvc.perform(post("/backoffice/products/editProduct")
				.param("productId", Integer.toString(PRODUCT_ID))
				.param("price", PRODUCT_PRICE.toString())
				.param("description", PRODUCT_DESCRIPTION)
				.param("categoryId", PRODUCT_CATEGORY_ID.toString())
				)
		.andExpect(view().name("redirect:/backoffice/products/" + PRODUCT_ID))
		.andExpect(flash().attributeExists("hasErrors", "org.springframework.validation.BindingResult.editProductForm", "editProductForm"));
	}
}
