package com.movebrick.elasticsearch.module.repository;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.movebrick.elasticsearch.module.bean.User;

@Repository
@Document(indexName = "blog",type = "user",shards=1,replicas=0)
public interface UserRepository extends ElasticsearchRepository<User,Long>{
	 
}
