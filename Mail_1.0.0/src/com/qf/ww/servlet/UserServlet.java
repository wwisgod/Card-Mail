package com.qf.ww.servlet;

import com.qf.ww.entity.Message;
import com.qf.ww.service.IUserService;
import com.qf.ww.service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet{
    private final IUserService userService =new UserServiceImpl();

    /**
     * 注册功能
     * @param request
     * @param response
     * @return
     */
    public Message register(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");

        String respMessage = userService.register(name, password, phone, email, sex);
        return new Message(respMessage);
    }

    /**
     *  登录功能
     * @param request
     * @param response
     * @return
     */
    public Message login(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        String serviceCode =(String)request.getSession().getAttribute("serviceCode");
        String respMessage = userService.login(name, password, code, serviceCode);

        int id = userService.getIdByName(name);
        //如果登录成功就将id存入session作用域中
        if(respMessage.equals("success")){
            request.getSession().setAttribute("id",id);
        }
        return new Message(respMessage,id,name);
    }

    /**
     *  注销功能
     * @param request
     * @param response
     * @return
     */
    public Message logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("id");
        return new Message("success");
    }

    public Message rePassword(HttpServletRequest request,HttpServletResponse response){
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        int id = (int)request.getSession().getAttribute("id");

        String respMessage = userService.rePassword(id, oldPassword, newPassword);
        if (respMessage.equals("success")){
            request.getSession().removeAttribute("id");
        }
        return new Message(respMessage);
    }
}
