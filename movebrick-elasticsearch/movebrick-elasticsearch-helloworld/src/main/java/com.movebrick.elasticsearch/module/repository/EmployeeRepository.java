package com.movebrick.elasticsearch.module.repository;

import com.movebrick.elasticsearch.module.bean.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ElasticsearchRepository<Employee, Long> {

}
