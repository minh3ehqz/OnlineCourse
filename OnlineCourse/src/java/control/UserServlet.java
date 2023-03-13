/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAL.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Acc;
import model.student;

/**
 *
 * @author WIN
 */
public class UserServlet extends HttpServlet {

    DAO d = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Acc ac = (Acc) ses.getAttribute("user");
        if (ac.getActive() == 1 || ac.getActive() == 3) {
            d.loadDepart();

            student st = d.checkUser(ac.getUserName());
            request.setAttribute("user", st);
            request.setAttribute("acc", ac);
            request.setAttribute("dao", d);
            request.setAttribute("userDe", ac.getDepid());
            request.getRequestDispatcher("VIEW/user.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession(false);
        String uname=(String) ses.getAttribute("name");
        String id = d.checkUser(uname).getID();
        if (id.length() != 0) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            boolean gender = request.getParameter("gender").equals("m");
            String depart = request.getParameter("depart");
            if (d.vailphone(phone)) {
                d.updateUser(id, name, phone, mail, gender, depart);
            }
            doGet(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
