package com.xinho.mybatis.session;


import com.xinho.mybatis.config.Configuration;
import com.xinho.mybatis.config.MapperRegistory;
import com.xinho.mybatis.executor.Executor;
import com.xinho.mybatis.proxy.MapperProxy;

import java.lang.reflect.Proxy;

/**
 * @author lhf
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2717:23
 */
public class SqlSession {
    private Executor executor;
    private Configuration configuration;

    public SqlSession(Executor executor, Configuration configuration) {
        this.executor = executor;
        this.configuration = configuration;
    }


    public <T> T selectOne(MapperRegistory.MapperData mapperData, String paramter) throws Exception {

        return executor.query(mapperData,paramter);
    }

    public <T> T getMapper(Class<T> mapperInterface){

        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{mapperInterface},
                new MapperProxy<>(this,mapperInterface));
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
