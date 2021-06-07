package com.qf.ww.servlet;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int width = 130;
        int height = 50;
        //1.创建一个带缓冲区的图片对象
        BufferedImage bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.获取画笔对象
        Graphics graphics = bImage.getGraphics();
        //3.设置画笔颜色
        graphics.setColor(Color.YELLOW);
        //4.填充背景颜色
        graphics.fillRect(0,0,width,height);
        //5.再次设置画笔颜色
        graphics.setColor(Color.RED);
        //6.设置字体样式
        graphics.setFont(new Font("宋体",Font.BOLD,30));
        //7.生成随机数
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int code;
        for (int i = 0; i < 4; i++) {
            code = ran.nextInt(10);
            sb.append(code+"");
            //8.写入数字+
            graphics.drawString(code+"",30+i*20,ran.nextInt(10)+30);
        }
        //验证码存放在静态属性中       --  不可用
        //serviceCode = sb.toString();

        //验证码存放到请求作用域中  --  不可用
        //request.setAttribute("serviceCode",sb.toString());

        //验证码存放到 session 作用域中   --  可用
        HttpSession session = request.getSession();
        session.setAttribute("serviceCode",sb.toString());

        //9.重新设置画笔颜色
        graphics.setColor(Color.BLUE);
        //10.绘制干扰线
        for (int i = 0; i < 10; i++) {
            //x的起点，y的起点，x的终点，y的终点
            graphics.drawLine(ran.nextInt(width),ran.nextInt(height),ran.nextInt(width),ran.nextInt(height));
        }
        //11.把绘制好的图片响应回请求方
        ImageIO.write(bImage,"jpg",response.getOutputStream());
    }
}
