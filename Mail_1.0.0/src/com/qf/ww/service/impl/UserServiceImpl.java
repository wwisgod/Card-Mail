package com.qf.ww.service.impl;

import com.qf.ww.dao.IUserDao;
import com.qf.ww.dao.impl.UserDaoImpl;
import com.qf.ww.entity.User;
import com.qf.ww.service.IUserService;

public class UserServiceImpl implements IUserService {
    private final IUserDao userDao = new UserDaoImpl();
    @Override
    public String register(String name, String password, String phone, String email, String sex) {
        User user = new User(name, password, phone, email, sex);
        int count = userDao.checkUsername(user);
        if(count==1){
            return "error";
        }else {
            userDao.addUser(user);
            return "success";
        }
    }

    @Override
    public String login(String name, String password, String code, String serviceCode) {
        int count = userDao.checkUser(name, password);
        if(count==1){
            if (!serviceCode.equals(code)){
                return "codeError";
            }
            return "success";
        }else {
            return "error";
        }
    }

    @Override
    public int getIdByName(String name) {
        return userDao.getIdByName(name);
    }

    @Override
    public String rePassword(int id, String oldPassword, String newPassword) {
        int count = userDao.checkOldPassword(id, oldPassword);
        if(count==0){
            return "error";
        }else {
            userDao.updatePassword(id,newPassword);
            return "success";
        }
    }
}
