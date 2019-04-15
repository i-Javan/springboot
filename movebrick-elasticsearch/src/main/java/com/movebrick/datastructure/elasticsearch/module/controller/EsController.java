package com.movebrick.datastructure.elasticsearch.module.controller;

import com.movebrick.datastructure.elasticsearch.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movebrick.datastructure.elasticsearch.module.bean.User;
import com.movebrick.datastructure.elasticsearch.module.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/pc/es")
public class EsController{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping("/getList")
	public Object get(){
		return userRepository.findAll();
	}
	
	/*@GetMapping("/getByKey")
	public Object getByKey(){
		return userRepository
	}*/
	
	@GetMapping("/save")
	public Object save(User user){
//		user.setName("zeng");
//		user.setAge("20");
//		user.setEmail("344556@qq.com");
//		user.setId(00002);
		return userRepository.save(user);
	}

	@GetMapping("/getEsInfo")
	public void findByTitleLikeorContentLike(User user){
		List<User> userList = new ArrayList<>();

		userList.add(new User(1, "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
		userList.add(new User(2, "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
		userList.add(new User(3, "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
		userList.add(new User(4, "Spring Data + ElasticSearch", "Rambabu Posa", "01-APR-2017"));
		userList.add(new User(5, "Spring Boot + MongoDB", "Mkyong", "25-FEB-2017"));

		for (User user1 : userList) {
			userRepository.save(user1);
		}
		Page<User> byAuthor = userService.findByTitleLikeorContentLike("El","25", new PageRequest(0, 10));
		byAuthor.forEach(x -> System.out.println("获取到的数据="+x));
	}

}
