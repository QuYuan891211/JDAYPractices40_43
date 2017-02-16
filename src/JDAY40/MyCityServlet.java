package JDAY40;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by qy on 2017/2/16.
 */
@WebServlet(name = "MyCityServlet")
public class MyCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        System.out.print(name);
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write("<?xml version='1.0' encoding='UTF-8'?>");
        pw.write("<root>");
        switch (name){
            case "江苏":
                pw.write("<option>南京</option>");
                pw.write("<option>连云港</option>");
                pw.write("<option>无锡</option>");
                pw.write("<option>苏州</option>");
                pw.write("<option>南通</option>");
                pw.write("<option>淮安</option>");
                pw.write("<option>常州</option>");
                pw.write("<option>盐城</option>");
                pw.write("<option>镇江</option>");
                pw.write("<option>徐州</option>");
                pw.write("<option>台州</option>");
                break;
            case "广东":
                pw.write("<option>广州</option>");
                pw.write("<option>深圳</option>");
                pw.write("<option>汕尾</option>");
                pw.write("<option>汕头</option>");
                pw.write("<option>中山</option>");
                pw.write("<option>珠海</option>");
                break;
            case "请选择":
                pw.write("<option>请选择</option>");
            default:
                System.out.print("没有匹配的");
                break;
        }
        pw.write("</root>");
        pw.flush();
        pw.close();



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
