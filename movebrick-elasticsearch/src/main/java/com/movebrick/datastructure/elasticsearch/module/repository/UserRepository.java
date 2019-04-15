package com.movebrick.datastructure.elasticsearch.module.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.movebrick.datastructure.elasticsearch.module.bean.User;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,Long>{
	Page<User> findByNameIsLikeOrEmailLike(String author,String email, Pageable pageable);
}
