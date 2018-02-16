package controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class TestLanguageToggleController {

	private String language;
	private String view;
	private String forward;

	@Before
	public void setUp() {
		this.language = "en";
		this.view = "/category/1";
		this.forward = "forward:/" + view;
	}

	@Test
	public void testChooseLanguage() throws Exception {
		LanguageToggleController controller = new LanguageToggleController();

		MockMvc mockMvc = standaloneSetup(controller).build();

		mockMvc.perform(get("/chooseLanguage").param("language", this.language).sessionAttr("view", this.view))
				.andExpect(view().name(this.forward))
				.andExpect(model().attribute("language", this.language));
	}
}
