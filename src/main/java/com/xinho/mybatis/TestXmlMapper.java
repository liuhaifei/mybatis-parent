package com.xinho.mybatis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lhf
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/7/2717:52
 */
public class TestXmlMapper {
    public static final String nameSpace="com.xinho.mybatis.mapper";
    private static final Map<String,String> methodSqlMap=new HashMap<String, String>();

    static {
        methodSqlMap.put("selectById","select * form user where userId=%d");
    }
}
