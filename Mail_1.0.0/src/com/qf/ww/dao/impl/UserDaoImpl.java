package com.qf.ww.dao.impl;

import com.qf.ww.dao.IUserDao;
import com.qf.ww.entity.User;
import com.qf.ww.utils.DBManager;
import com.qf.ww.utils.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    @Override
    public int checkUsername(User user) {
        Integer count = DBManager.commonCount("select count(*) from user where name=?", user.getName());
        return count;
    }

    @Override
    public int addUser(User user) {
        Integer rSet = DBManager.commonUpdate(
                "insert into user(name,password,phone,email,sex) value(?,?,?,?,?)",
                user.getName(),
                user.getPassword(),
                user.getPhone(),
                user.getEmail(),
                user.getSex());
        return rSet;
    }

    @Override
    public int checkUser(String name,String password) {
        Integer count = DBManager.commonCount("select count(*) from user where name=? and password=?",name,password);
        return count;
    }

    @Override
    public int getIdByName(String name) {
        Connection connection =null;
        PreparedStatement ps =null;
        ResultSet rSet =null;
        int id = 0;
        try {
            connection = DruidUtils.getConnection();
            ps = connection.prepareStatement("select id from user where name=?");
            ps.setString(1,name);
            rSet = ps.executeQuery();
            if(rSet.next()){
                id = rSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.closeAll(rSet,ps,connection);
        }
        return id;
    }

    @Override
    public int checkOldPassword(int id, String oldPassword) {
        Integer rSet = DBManager.commonCount("select count(*) from user where id=? and password=? ", id, oldPassword);
        return rSet;
    }

    @Override
    public int updatePassword(int id, String newPassword) {
        Integer rSet = DBManager.commonUpdate("update user set password=? where id=?",newPassword,id);
        return rSet;
    }
}
