package com.markus.project.service;

/**
 * @author: markus
 * @date: 2022/7/9 8:35 下午
 * @Description: 用户服务类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class UserService {

    private String name;

    public UserService() {
        this.name = "默认构造器";
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + name);
        ;
    }
}
