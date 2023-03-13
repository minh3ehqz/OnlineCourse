/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAL.DAO;
import DAL.processDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Acc;
import model.process;
import model.student;

/**
 *
 * @author WIN
 */
public class UserInfoServlet extends HttpServlet {

    DAO d = new DAO();
    processDAO pr = new processDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Acc ac = (Acc) ses.getAttribute("user");
        Object obj = request.getParameter("type");
        String type = (obj == null ? "" : (obj + ""));
        obj = request.getParameter("id");
        String id = (obj == null ? "" : (obj + ""));
        if (type.equals("2") && id.length() != 0) {
            pr.deletePro(id);
        }
        if (ac.getActive() == 1 || ac.getActive() == 3) {
            d.loadDepart();
            student st = d.checkUser(ac.getUserName());
            pr.loadProcess(st.getID());
            pr.viewProcess(pr.getP(),st.getID());

            request.setAttribute("process", pr);
            request.setAttribute("user", st);
            request.setAttribute("dao", d);
            request.getRequestDispatcher("VIEW/userinfor.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
