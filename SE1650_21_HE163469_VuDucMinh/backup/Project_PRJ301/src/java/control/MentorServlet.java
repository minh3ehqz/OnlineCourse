/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAL.processDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
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
public class MentorServlet extends HttpServlet {

    processDAO pr = new processDAO();
    String clid;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        clid = request.getParameter("id");
        ArrayList mlist = pr.mentorlis(clid);
        request.setAttribute("mlist", mlist);
        request.setAttribute("classmID", clid);
        request.getRequestDispatcher("/VIEW/mentor.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pass = request.getParameter("pass");
        
        HttpSession ses = request.getSession();
        Acc ac = (Acc) ses.getAttribute("user");
        if (pass.equals(ac.getPassWord().trim())) {
            String[] id = request.getParameterValues("stid");
            String []obj = new String[id.length];
            int []st = new int[id.length];
            for(int i = 0;i<id.length;i++){
                obj[i]=request.getParameter(id[i]+"classST");
                st[i] =Integer.parseInt(obj[i]);
            }
             for(int i = 0;i<id.length;i++){
                 pr.updatepr(st[i], clid, id[i]);
             }
        }
        response.sendRedirect("MentorServlet?id=" + clid);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
