package com.qf.ww.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Ran
 * @since JDK 1.8
 * <p>
 * Dao层的工具类
 */
public class DBManager {
    //1.更新操作            --  返回值是 int 类型，操作数
    public static Integer commonUpdate(String sql, Object... obj) {
        Connection connection = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            connection = DruidUtils.getConnection();
            //开启事务
            connection.setAutoCommit(false);
            //预处理 sql 语句
            ps = connection.prepareStatement(sql);
            //给占位符赋值
            for (int i = 0; i < obj.length; i++) {
                ps.setObject(i + 1, obj[i]);
            }
            //执行 sql 语句 返回结果集
            rSet = ps.executeUpdate();
            //提交事务
            connection.commit();
        } catch (SQLException e) {
            try {
                //回滚
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(ps, connection);
        }
        return rSet;
    }
    //2.查询多个用户的数据  --  返回值是 List 类型，执行 sql 语句返回 Result对象， 多个用户对象
    public static <T> List<T> commonQuery(String sql, Class<T> clazz, Object... obj) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<T> list = new ArrayList<>();
        T t;
        try {
            connection = DruidUtils.getConnection();
            ps = connection.prepareStatement(sql);
            //判断需不需要给占位符赋值
            if (obj != null) {
                //给占位符进行赋值
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i + 1, obj[i]);
                }
            }
            //执行sql语句
            rSet = ps.executeQuery();
            //遍历结果集获取属性并封装成对象,再把对象存储到集合中
            while (rSet.next()) {
                //1.创建实例对象    --  通过反射对象调用无参构造方法创建实例对象
                t = clazz.newInstance();
                //2.获取实体类的属性名，把属性名当做是字段名获取字段数据
                //获取所有属性对象
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //打开访问权限
                    field.setAccessible(true);
                    if (field.getType()== Date.class){
                        String name = field.getName();
                        Timestamp timestamp = rSet.getTimestamp(name);
                        Date date = DateUtils.t2d(timestamp);
                        field.set(t,date);
                    }else {
                        //获取属性名
                        String name = field.getName();
                        //根据属性名获取字段数据
                        Object value = rSet.getObject(name);
                        //给实例对象的属性进行赋值
                        field.set(t, value);
                    }
                }
                //把实例对象添加到集合中
                list.add(t);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        } finally {
            DruidUtils.closeAll(rSet, ps, connection);
        }
        return list;
    }
    //3.查询个数            --  返回值是 int 类型，执行 sql 语句返回 Result对象，统计数
    public static Integer commonCount(String sql,Object ... obj){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        int count = 0;
        try {
            connection = DruidUtils.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            if(obj != null){
                for (int i = 0; i < obj.length; i++) {
                    ps.setObject(i+1,obj[i]);
                }
            }
            rSet = ps.executeQuery();
            if(rSet.next()){
                count = rSet.getInt(1);
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DruidUtils.closeAll(rSet,ps,connection);
        }
        return count;
    }
}
