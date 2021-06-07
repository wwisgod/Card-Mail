package com.qf.ww.dao;

import com.qf.ww.entity.User;

public interface IUserDao {
    /** 注册
     * 查询用户名是否已存在
     * @param user
     * @return  1存在 0不存在
     */
    int checkUsername(User user);

    /**
     *  注册
     *  添加用户信息
     * @param user
     * @return 1操作成功 0操作失败
     */
    int addUser(User user);

    /**
     *  登录
     *  查询用户名和密码是否匹配
     * @param name 用户名
     * @param password 密码
     * @return 1匹配 0不匹配
     */
    int checkUser(String name,String password);

    /**
     *  根据用户名获取目标用户id
     * @param name
     * @return id
     */
    int getIdByName(String name);

    /**
     * 查询该用户旧密码是否正确
     * @param id
     * @param oldPassword
     * @return 1正确  0错误
     */
    int checkOldPassword(int id,String oldPassword);

    /**
     *  更新密码
     * @param id
     * @param newPassword
     * @return 1操作成功 0操作失败
     */
    int updatePassword(int id,String newPassword);
}
