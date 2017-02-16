package JDAY40;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by qy on 2017/2/16.
 */
@WebServlet(name = "CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String code = request.getParameter("code");
        //获取服务端产生的验证码
        HttpSession httpSession = request.getSession();
        String checkcodeServer = (String) httpSession.getAttribute("CHECKNUM");
        String src = "images/MsgError.gif";
        if(code!=null && checkcodeServer!= null && code.equals(checkcodeServer)){
            src = "images/MsgSent.gif";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.write(src);
        pw.flush();
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
