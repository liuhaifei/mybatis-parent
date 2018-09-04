package com.xinho.mybatis.mappers;

import com.xinho.mybatis.beans.User;

/**
 * @ClassName TestMapper
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/4 14:31
 * @Version 1.0
 **/
public interface TestMapper {
    User selectByPrimaryKey(Integer userId);
}
