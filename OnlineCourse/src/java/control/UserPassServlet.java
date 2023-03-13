/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import DAL.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author WIN
 */
public class UserPassServlet extends HttpServlet {
    DAO d = new DAO();
    loginDAO lg = new loginDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("/VIEW/userPass.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            HttpSession ses = request.getSession(false);
            String uname=(String) ses.getAttribute("name");
            String id = d.checkUser(uname).getID();
            if(id.length()!=0){
                String oldpsw = request.getParameter("oldpsw");
                String psw = request.getParameter("psw");
                String repsw=request.getParameter("repsw");
                if(lg.checklog(uname, oldpsw)!=null){
                    if(psw.equals(repsw)){
                        d.upadtePassU(psw, id);
                    }
                }
            }
            doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
