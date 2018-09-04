package com.xinho.mybatis.executor;

import com.xinho.mybatis.config.Configuration;
import com.xinho.mybatis.config.MapperRegistory;
import com.xinho.mybatis.statement.StatementHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CachingExecutor
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/4 16:33
 * @Version 1.0
 **/
public class CachingExecutor implements Executor {

    private Configuration configuration;
    private SimpleExecutor delegate;

    private Map<String,Object> localCache=new HashMap<>();

    public CachingExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    public CachingExecutor(SimpleExecutor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> T query(MapperRegistory.MapperData mapperData, String paramter) throws Exception {

        StatementHandler statementHandler=new StatementHandler(configuration);
        Object result=localCache.get(mapperData.getSql());
        if(result!=null){
            System.out.println("命中缓存");
            return (T)result;
        }
        result=(T)delegate.query(mapperData,paramter);
        localCache.put(mapperData.getSql(),result);
        return (T)result;
    }
}
