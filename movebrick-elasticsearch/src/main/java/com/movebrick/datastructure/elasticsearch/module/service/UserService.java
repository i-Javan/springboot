package com.movebrick.datastructure.elasticsearch.module.service;

import com.movebrick.datastructure.elasticsearch.module.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserService {
    Page<User> findByTitleLikeorContentLike(String name,String email, PageRequest pageRequest);
}
