package com.xinho.mybatis;


import java.lang.reflect.Proxy;

/**
 * @author lhf
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2717:23
 */
public class MSqlSession {
    MExecutor executor=new MSimpleExecutor();

    public <T> T selectOne(String statement, String paramter){

        return executor.query(statement,paramter);
    }

    public <T> T getMapper(Class<T> mapperInterface){

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{mapperInterface},
                new MMapperProxy<>(this,mapperInterface));
    }
}
