package com.movebrick.elasticsearch.module.service.impl;

import com.movebrick.elasticsearch.module.bean.User;
import com.movebrick.elasticsearch.module.repository.UserRepository;
import com.movebrick.elasticsearch.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Page<User> findByTitleLikeorContentLike(String name, String email, PageRequest pageRequest) {

        //return userRepository.findByTitleLikeorContentLike(name,pageRequest);
        return userRepository.findByNameIsLikeOrEmailLike(name,email,pageRequest);
    }
}
