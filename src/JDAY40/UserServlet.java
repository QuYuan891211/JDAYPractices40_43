package JDAY40;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����HTML����GET��POST��ʽ�����ע���û����Ƿ������ݿ����Ѵ��� 
 * @author AdminTC
 */
public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String username = request.getParameter("username");
		byte[] buf = username.getBytes("ISO8859-1");
		username = new String(buf,"UTF-8");
		System.out.println("username=" + username);
		String tip = "<font color='green'>����ע��</font>";
		if("�ܿ�".equals(username)){
			tip = "<font color='red'>���û��Ѵ���</font>";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println("username=" + username);
		
		String tip = "images/MsgSent.gif";
		if("Jack".equals(username)){
			tip = "images/MsgError.gif";
		}
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
}







