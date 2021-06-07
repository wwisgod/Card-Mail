package com.qf.ww.service;

public interface IUserService {
    /**
     *  注册业务
     * @param name  用户名
     * @param password  密码
     * @param phone 手机号码
     * @param email 邮箱
     * @param sex  性别
     * @return  success 注册成功    error 注册失败（用户名已存在）
     */
    String register(String name,String password,String phone,String email,String sex);

    /**
     *  登录验证业务
     * @param name 输入的用户名
     * @param password 输入的密码
     * @param code     输入的验证码
     * @param serviceCode 生成的验证码
     * @return success 登录验证成功   error 用户名或密码错误   codeError 验证码错误
     */
    String login(String name,String password,String code,String serviceCode);

    /**
     *  获取当前用户id
     * @param name
     * @return id
     */
    int getIdByName(String name);

    /**
     *  修改密码业务
     * @param id  修改的用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return success 修改成功 error 旧密码不正确
     */
    String rePassword(int id,String oldPassword,String newPassword);
}
