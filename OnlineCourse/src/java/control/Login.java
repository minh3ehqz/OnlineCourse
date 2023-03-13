/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAL.loginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Acc;

/**
 *
 * @author WIN
 */
public class Login extends HttpServlet {

    loginDAO ld = new loginDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("VIEW/login.jsp").forward(request, response);
    }

    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("uname");
        String passWord = request.getParameter("psw");
        Object login = request.getParameter("login");
        int sessionLive=20;
        if(login!=null){
            if(ld.checklog(userName, passWord)!=null){
                if(ld.checklog(userName, passWord).getActive()>0){
                HttpSession user=request.getSession();
                HttpSession depid=request.getSession();
                HttpSession userN=request.getSession();
              
                userN.setAttribute("name", userName);
                user.setAttribute("user", ld.checklog(userName, passWord));
                depid.setAttribute("depid", ld.checklog(userName, passWord).getDepid());
                response.sendRedirect("HomeServlet");
            }else{
                  request.setAttribute("e_mess", "tài khoản chưa được kích hoạt"); 
                    doGet(request, response);
                }
            }else{
                request.setAttribute("e_mess", "tên đăng nhập hoặc mật khẩu sai");
                doGet(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
