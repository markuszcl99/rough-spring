package com.markus.project.service;

import com.markus.project.repository.UserDao;
import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.InitializingBean;

/**
 * @author: markus
 * @date: 2022/7/9 8:35 下午
 * @Description: 用户服务类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class UserService implements InitializingBean {

    private String name;

    private UserDao userDao;

    private String company;

    private String location;

    public UserService() {
        this.name = "默认构造器";
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息: " + userDao.queryUserName(name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void customInitMethod() {
        System.out.println("init-method update location field from [" + this.location + "]" + " to [北京顺义]");
        this.setLocation("北京顺义");
    }
    @Override
    public String toString() {
        return "UserService{" +
                "name='" + name + '\'' +
                ", userDao=" + userDao +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws BeansException {
        System.out.println("InitializingBean#afterPropertiesSet方法执行");
    }
}
