package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Getter;
import lombok.Setter;

@SpringBootTest
class SpringbootDemoApplicationTests {

	@Test
	@DisplayName("testing lombok")
	public void testGetterSetter() {
		User user = new User();
		user.setFirstName("anish");
		assertEquals(user.getFirstName(), "anish");
	}
	
	@Getter @Setter
	class User{
		private String firstName;
	}

}
