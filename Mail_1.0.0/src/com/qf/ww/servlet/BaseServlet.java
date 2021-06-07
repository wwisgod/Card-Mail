package com.qf.ww.servlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.响应结果为 json 格式数据
        response.setContentType("application/json;charset=utf-8");
        //2.获取action值
        String action = request.getParameter("action");
        //3.获取当前 Servlet 的反射对象
        Class<? extends BaseServlet> clazz = this.getClass();
        if(action == null) {
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = headerNames.nextElement();
                if ("action".equals(key)) {
                    //获取请求头名称的值
                    action = request.getHeader(key);
                }
            }
        }

        try {
            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            //调用方法返回对象
            Object obj = method.invoke(this, request, response);
            //把对象封装成json格式数据
            String json = JSONObject.toJSONString(obj);
            System.out.println(json);
            //响应前端
            response.getWriter().write(json);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
