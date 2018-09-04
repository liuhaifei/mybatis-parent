package com.xinho.mybatis.result;

import com.xinho.mybatis.config.Configuration;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName ResultSetHandler
 * @Description TODO
 * @Author 刘海飞
 * @Date 2018/9/4 14:53
 * @Version 1.0
 **/
public class ResultSetHandler {
    private final Configuration configuration;

    public ResultSetHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    public <E> E handle(ResultSet rs,Class type) throws SQLException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object resultObject=new DefaultObjectFactory().create(type);
        if(rs.next()){
            int i=0;
            for(Field field:resultObject.getClass().getDeclaredFields()){
                setValue(resultObject,field,rs,i);
            }
        }
        return (E)resultObject;
    }

    private void setValue(Object resultObject, Field field, ResultSet rs, int i) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, SQLException {
        Method setMethod=resultObject.getClass().getMethod("set"+upperCapital(field.getName()),field.getType());

        setMethod.invoke(resultObject,getResult(field,rs));
    }

    private Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type=field.getType();
        if(Integer.class==type){
            return rs.getInt(field.getName());
        }
        if(String.class==type){
            return rs.getString(field.getName());
        }
        return rs.getString(field.getName());
    }

    private String upperCapital(String name) {
        String first=name.substring(0,1);
        String tail=name.substring(1);

        return first.toUpperCase()+tail;
    }
}
