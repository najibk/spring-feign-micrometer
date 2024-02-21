package com.example.demo;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWireMock(stubs="classpath:/templates", port = 8089)
class DemoApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"));
		WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/name"))
				.withHeader("traceparent", WireMock.containing("00-")));
	}

}
