package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class PagedRestController {
	// links automatically created repository bean in
	// Spring Application context
	@Autowired
	UserRepository data;

	@GetMapping("/pageone")
	public List<UserEntity> getPageOne() {

		// First page with 5 items
		Pageable paging = PageRequest.of(0, 5, Sort.by("user").ascending());
		Page<UserEntity> page = data.findAll(paging);
		
		return page.getContent();
	}

	@GetMapping("/pagetwo")
	public List<UserEntity> getPageTwo() {

		// Second page with another 5 items
		Pageable paging = PageRequest.of(1, 5, Sort.by("user").ascending());
		Page<UserEntity> page = data.findAll(paging);

		// Retrieve the items
		return page.getContent();
	}

}
