package com.xinho.mybatis.beans;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/4 14:32
 * @Version 1.0
 **/
@Data
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private String addr;
    private String sex;
}
