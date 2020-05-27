package com.example.springboot.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.PhoneService.PhoneService;

@SpringBootTest
class PhoneServiceTest {

	@Autowired
	PhoneService phoneService;
	
	@Test
	void test() {
		assertEquals(5120, phoneService.getAllResults("1234567").size());
		assertEquals(102400, phoneService.getAllResults("1234567890").size());
	}

}
