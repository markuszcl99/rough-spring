package com.markus.demo.IoC;

/**
 * @author: markus
 * @date: 2022/7/8 12:07 上午
 * @Description: 年轻小伙子
 * @Blog: http://markuszhang.com/
 * It's my honor to share what I've learned with you!
 */
public class YoungMan {
    private BeautifulGirl beautifulGirl;

    public YoungMan() {
        // 牛逼，指腹为婚
        // this.beautifulGirl = new BeautifulGirl();
    }

    public YoungMan(BeautifulGirl beautifulGirl) {
        this.beautifulGirl = beautifulGirl;
    }

    public BeautifulGirl getBeautifulGirl() {
        return beautifulGirl;
    }

    public void setBeautifulGirl(BeautifulGirl beautifulGirl) {
        this.beautifulGirl = beautifulGirl;
    }

    public static void main(String[] args) {
        BeautifulGirl beautifulGirl = new BeautifulGirl();// 理解好控制反转，重点在于看这个对象的实例化是由谁来生成的
        YoungMan youngMan = new YoungMan(beautifulGirl);// 构造器注入
        youngMan.setBeautifulGirl(beautifulGirl);// setter方法注入
    }
}
