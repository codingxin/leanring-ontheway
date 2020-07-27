package com.codingzx.Stream基础使用.HashMap排序题;

import lombok.Data;
import lombok.ToString;

/**
 * @author created by zhangxin27695
 * @Classname User
 * @Description
 * @Date 2020-06-14 11:31
 */
@ToString
@Data
public class User {
    String username;
    Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
