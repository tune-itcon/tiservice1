package com.ti.tiservice1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ti.tiservice1.model.ServiceResponse;

@RunWith(SpringRunner.class)
@WebMvcTest
public class Tiservice1ApplicationTests {

	@Autowired
	MockMvc mockMvc;
	
	@Before
	public void Setup() {
	}
	
	
	
	@Test
	public void contextLoads() throws Exception {
		
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/getServiceName").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ServiceResponse res = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), ServiceResponse.class);
	
		assertNotNull(res);
		assertEquals("service1", res.getName());

	}

}
