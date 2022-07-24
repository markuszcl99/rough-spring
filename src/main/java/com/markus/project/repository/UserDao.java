package com.markus.project.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: markus
 * @date: 2022/7/14 11:55 下午
 * @Description: 用户数据层
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "markus");
        hashMap.put("10002", "luna");
        hashMap.put("10003", "静香");
    }

    public String queryUserName(String userId) {
        return hashMap.get(userId);
    }

    @Override
    public String toString() {
        return "UserDao{}";
    }
}
