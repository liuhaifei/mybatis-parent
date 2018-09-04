package com.xinho.mybatis.executor;

import com.xinho.mybatis.config.MapperRegistory;

/**
 * @author lhf
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2717:38
 */
public interface Executor {

    <T> T query(MapperRegistory.MapperData mapperData, String paramter) throws Exception;
}
