/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author WIN
 */
public class registerServlet extends HttpServlet {

    DAO dao;

    public void init() {
        dao = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao.loadDepart();
        request.setAttribute("dao", dao);
        request.getRequestDispatcher("VIEW/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] checkvail={"","","","",""};
        String userName = request.getParameter("uname");
        String password = request.getParameter("psw");
        String repass = request.getParameter("re_psw");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        boolean gender = request.getParameter("gender").equals("m");
        String depat = request.getParameter("depart");
        if(dao.Vail(userName, password,repass, phone, mail, checkvail)){
            dao.InserUser(gender, depat, userName, phone, userName, password, mail);
            doGet(request, response);
        }else{
            request.setAttribute("emess", checkvail);
            doGet(request, response);
        }
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
