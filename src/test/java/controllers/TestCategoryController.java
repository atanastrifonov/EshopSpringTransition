package controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import dto.CategoryProductData;
import facade.capi.CategoryFacade;
import facade.impl.DefaultCategoryFacade;

public class TestCategoryController {

	private CategoryProductData expectedCategory;

	@Before
	public void setUp() {
		this.expectedCategory = new CategoryProductData((short) 1, "theSelectedOne");
	}

	@Test
	public void testShowCategory() throws Exception {
		CategoryFacade mockFacade = mock(DefaultCategoryFacade.class);
		when(mockFacade.getCategoryProductById((short) 1)).thenReturn(expectedCategory);

		CategoryController controller = new CategoryController();
		ReflectionTestUtils.setField(controller, "categoryFacade", mockFacade);

		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/category.jsp")).build();

		mockMvc.perform(get("/category/1"))
				.andExpect(view().name("category"))
				.andExpect(model().attributeExists("selectedCategory"))
				.andExpect(model().attribute("selectedCategory", expectedCategory))
				.andExpect(request().sessionAttribute("selectedCategoryURL", "/category/1"));
	}
}
