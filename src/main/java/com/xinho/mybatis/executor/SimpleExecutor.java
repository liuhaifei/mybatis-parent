package com.xinho.mybatis.executor;

import com.xinho.mybatis.config.Configuration;
import com.xinho.mybatis.config.MapperRegistory;
import com.xinho.mybatis.statement.StatementHandler;

/**
 * @author lhf
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2717:39
 */
public class SimpleExecutor implements Executor {

    private Configuration configuration;

    public SimpleExecutor(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <E> E query(MapperRegistory.MapperData mapperData, String paramter) throws Exception {
        //初始化 statementHandler->ParamterHandler->ResultSetHandler
        StatementHandler handler=new StatementHandler(configuration);
        return (E)handler.query(mapperData,paramter);
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
}
