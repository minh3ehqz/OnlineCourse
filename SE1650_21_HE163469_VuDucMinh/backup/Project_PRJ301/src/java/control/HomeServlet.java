/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import DAL.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Array;
import java.util.ArrayList;
import model.*;

/**
 *
 * @author WIN
 */
public class HomeServlet extends HttpServlet {

    DAO dao;
    classDAO cl = new classDAO();

    public void init() {
        dao = new DAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dao.loadDepart();
        dao.loadStudent();
        cl.loadTop();
        HttpSession session = request.getSession(false);
        if (session != null) {
            Acc ac = (Acc) session.getAttribute("user");
            request.setAttribute("user", ac);
            cl.loadTopClassUser((String)session.getAttribute("depid"));
        } else {
            request.setAttribute("user", null);
        }
        request.setAttribute("dao", dao);
        request.setAttribute("topcl", cl);
        request.getRequestDispatcher("VIEW/home.jsp").forward(request, response);
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
