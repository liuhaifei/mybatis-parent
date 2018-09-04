package com.xinho.mybatis;

import com.xinho.mybatis.beans.User;
import com.xinho.mybatis.config.Configuration;
import com.xinho.mybatis.executor.ExecutorFactory;
import com.xinho.mybatis.mappers.TestMapper;
import com.xinho.mybatis.session.SqlSession;

import java.io.IOException;

/**
 * @ClassName BootStrap
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/4 16:55
 * @Version 1.0
 **/
public class BootStrap {
    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        Configuration configuration=new Configuration();
        configuration.setScanPath("com.xinho.mybatis.mappers");
        configuration.bulid();
        SqlSession sqlSession=new SqlSession(ExecutorFactory.get(ExecutorFactory.ExecutorType.CACHING.name(),configuration)
                                            ,configuration);
        TestMapper testMapper=sqlSession.getMapper(TestMapper.class);
        long start=System.currentTimeMillis();
        User test=testMapper.selectByPrimaryKey(1);
        System.out.println(test);
        System.out.println("cost:"+(System.currentTimeMillis()-start));
    }
}
