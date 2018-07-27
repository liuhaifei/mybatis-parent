package com.xinho.mybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lhf
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2717:49
 */
public class MMapperProxy<T> implements InvocationHandler {
    private final MSqlSession sqlSession;
    private final Class<T> mapperInterfaces;

    public MMapperProxy(MSqlSession sqlSession, Class<T> mapperInterfaces) {
        this.sqlSession = sqlSession;
        this.mapperInterfaces = mapperInterfaces;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(TestXmlMapper.nameSpace)){
//            String sql
        }
        return null;
    }
}
