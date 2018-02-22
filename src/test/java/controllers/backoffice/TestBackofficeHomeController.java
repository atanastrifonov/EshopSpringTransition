package controllers.backoffice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class TestBackofficeHomeController {
	
	@Test
	public void testGetHomePage() throws Exception{
		BackofficeHomeController controller = new BackofficeHomeController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/backoffice")).andExpect(view().name("admin/dashboard"));
	}

}
