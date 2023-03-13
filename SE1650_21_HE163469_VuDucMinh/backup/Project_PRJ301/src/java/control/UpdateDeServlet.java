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
import jakarta.servlet.http.HttpSession;
import model.Acc;
import model.Department;

/**
 *
 * @author WIN
 */
public class UpdateDeServlet extends HttpServlet {

    DAO d = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object obj = request.getParameter("id");
        String id = (obj == null ? "" : (obj + ""));
        Department de = d.departByID(id);
        request.setAttribute("d", de);
        request.getRequestDispatcher("/VIEW/updateDE.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Acc ac = (Acc) ses.getAttribute("user");
        String pass = request.getParameter("passadmin");
        if (pass.equals(ac.getPassWord().trim())) {
            String id = (String) request.getParameter("deName");
            String name = (String) request.getParameter("dname");
            String title = (String) request.getParameter("dtitle");
            String im = (String) request.getParameter("dimages");
            d.updateDE(id, name, title, im);
        }
        response.sendRedirect("ADdepartServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
