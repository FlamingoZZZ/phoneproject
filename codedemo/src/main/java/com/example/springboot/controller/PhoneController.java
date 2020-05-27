package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.PhoneService.PhoneService;
import com.example.springboot.domain.PageInfo;

@RestController
public class PhoneController {
	
	@Autowired
	PhoneService phoneservice;
	
	@GetMapping("/result/{phone}")
	public PageInfo getAllResults(@RequestParam(value = "pageNum",defaultValue = "1") Integer page, @PathVariable("phone") String phone) {
		List<String> ans = phoneservice.getAllResults(phone);
		List<String> result = new ArrayList<>();
		int totalPage = (ans.size() / 50) + 1;
		int lowerIndex = (page - 1) * 50;
		for (int i = 0; i < 50; i++) {
			if (lowerIndex + i >= ans.size()) {
				break;
			}
			result.add(ans.get(lowerIndex + i));
		}
		return new PageInfo(page, totalPage, result);
	}

	
}
