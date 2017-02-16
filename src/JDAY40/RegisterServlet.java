package JDAY40;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by qy on 2017/2/16.
 */
public class RegisterServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        String img = "JDAY40/images/MsgError.gif";
        if("jack".equals(name)){
            img = "JDAY40/images/MsgSent.gif";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer  = response.getWriter();
        writer.write(img);
        writer.flush();
        writer.close();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
       this.doPost(request,response);
    }
}
