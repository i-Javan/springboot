package com.movebrick.jpa;

import com.movebrick.jpa.module.dao.UserRepository;
import com.movebrick.jpa.module.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void before() {
        System.err.println("----- Before -----");
    }

    @Test
    public void testAdd() {
        User u = new User();
        String uuid = UUID.randomUUID().toString();
        int l = (int)System.currentTimeMillis();
        System.err.println("UUID:"+uuid);
        System.err.println("TimeMillis:"+l);
        u.setId( l);
        u.setAge("2");
        u.setName(uuid);
        u.setEmail(uuid+"@gmail.com");
        userRepository.save(u);
        System.err.println("通过ID查询:");
        Optional<User> byId = userRepository.findById(u.getId());
        System.err.println(byId);
        //查询全部
        System.err.println("查询全部:");
        List<User> all = userRepository.findAll();
        System.err.println(all);
        //自定义方法
        System.err.println("自定义方法:");
        List<User> userByAge = userRepository.getUserByAge(1);
        System.err.println(userByAge);

        System.err.println("分页查询：");
        Sort sortid =new Sort(Sort.Direction.ASC,"id");
        PageRequest pageRequest = new PageRequest(0,2, sortid);
        //index偏移量 num查询数量 sort排序
        Page<User> all2 = userRepository.findAll(pageRequest);
        System.err.println(all2);

        System.err.println("Sort_排序：");
        Sort sort =new Sort(Sort.Direction.ASC,"id");
        //其中第一个参数表示是降序还是升序（此处表示升序）
        //第二个参数表示你要按你的 entity（记住是entity中声明的变量，不是数据库中表对应的字段）中的那个变量进行排序
        List<User> all1 = userRepository.findAll(sort);
        System.err.println(all1);

        System.err.println("分页+排序实现:");
        User user2 = new User();
        user2.setId(l); //查询条件
        //创建查询参数
        Example<User> example = Example.of(user2);
        //获取排序对象
        Sort sort2 = new Sort(Sort.Direction.DESC, "id");
        //创建分页对象
        PageRequest pageRequest2 = new PageRequest(0,2, sort2);
        //分页查询
        Page<User> all3 = userRepository.findAll(example, pageRequest2);
        System.err.println(all3);


        System.err.println("使用匹配器：");

        User user3 = new User();
        user3.setId(l); //查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true) //改变默认大小写忽略方式：忽略大小写
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.startsWith()) //地址采用“开始匹配”的方式查询
                .withIgnorePaths("focus");  //忽略属性：是否关注。因为是基本类型，需要忽略掉
        //创建实例
        Example<User> ex = Example.of(user3, matcher);
        //查询
        List<User> ls = userRepository.findAll(ex);
        System.err.println(ls);

        System.err.println("查询空值：");
        User user4 = new User();
        //user4.setId(l); //查询条件
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher1 = ExampleMatcher.matching() //构建对象
                .withIncludeNullValues() //改变“Null值处理方式”：包括
                .withIgnorePaths("id","name","age","email");  //忽略其他属性
        //创建实例
        Example<User> ex1 = Example.of(user4, matcher1);

        //查询
        List<User> ls1 = userRepository.findAll(ex1);
        System.err.println(ls1);
    }

    @Test
    public void get(){

    }

    @After
    public void after() {
        System.err.println("----- After -----");
    }
}
