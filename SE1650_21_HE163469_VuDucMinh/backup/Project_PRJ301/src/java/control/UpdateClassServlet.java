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
import model.Acc;
import model.ClassR;

/**
 *
 * @author WIN
 */
public class UpdateClassServlet extends HttpServlet {

    classDAO lg = new classDAO();
    DAO dao = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object obj = request.getParameter("id");
        String id = (obj == null ? "" : (obj + ""));
        ClassR c = lg.classbyID(id);
        dao.loadDepart();
        request.setAttribute("cl", c);
        request.setAttribute("dao", dao);
        request.getRequestDispatcher("/VIEW/updateClass.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Acc ac = (Acc)ses.getAttribute("user");
        String pass = request.getParameter("passadmin");
        if (pass.equals(ac.getPassWord().trim())) {
            String clname = (String) request.getParameter("clName");
            String deID = (String) request.getParameter("de");
            String title = (String) request.getParameter("title");
            String im = (String) request.getParameter("images");
            lg.updateCl(clname, deID, title, im);
        }
        response.sendRedirect("ADclassServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
