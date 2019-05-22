package com.movebrick.elasticsearch.module.service;

import com.movebrick.elasticsearch.module.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface UserService {
    Page<User> findByTitleLikeorContentLike(String name,String email, PageRequest pageRequest);
}
