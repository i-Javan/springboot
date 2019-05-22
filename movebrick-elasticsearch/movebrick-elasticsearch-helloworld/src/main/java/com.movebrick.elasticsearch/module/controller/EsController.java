package com.movebrick.elasticsearch.module.controller;

import com.movebrick.elasticsearch.module.bean.Employee;
import com.movebrick.elasticsearch.module.bean.User;
import com.movebrick.elasticsearch.module.repository.EmployeeRepository;
import com.movebrick.elasticsearch.module.repository.UserRepository;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/pc/es")
public class EsController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getList")
    public Object get() {
        return userRepository.findAll();
    }

    @GetMapping("/EgetList")
    public Object Eget() {
        return employeeRepository.findById(1l);
    }

	/*@GetMapping("/getByKey")
	public Object getByKey(){
		return userRepository
	}*/

    @PostMapping("/save")
    public Object save(User user) {
        return userRepository.save(user);
    }


    @PostMapping("/Esave")
    public Object Esave(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     *
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Employee> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Employee> searchResult = employeeRepository.search(builder);
        Iterator<Employee> iterator = searchResult.iterator();
        List<Employee> list = new ArrayList<Employee>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
