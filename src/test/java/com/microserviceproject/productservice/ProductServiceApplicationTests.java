package com.microserviceproject.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microserviceproject.productservice.dto.ItemDto;
import com.microserviceproject.productservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@RequiredArgsConstructor
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper jacksonObjectMapper;

	@Autowired
	private ItemRepository itemRepository;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
	}

	@Test
	void shouldCreateItem() throws Exception {
		ItemDto itemDto = ItemDto.builder()
							.title("Super Nintendo")
							.description("Classic/mini")
							.price(BigDecimal.valueOf(99.99))
							.build();
		String s = jacksonObjectMapper.writeValueAsString(itemDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/items")
				.contentType(MediaType.APPLICATION_JSON)
				.content(s))
				.andExpect(status().isCreated());
	}

}
