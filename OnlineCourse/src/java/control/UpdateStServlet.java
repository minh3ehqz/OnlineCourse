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
import model.Acc;
import model.student;

/**
 *
 * @author WIN
 */
public class UpdateStServlet extends HttpServlet {

    DAO d = new DAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object obj = request.getParameter("AccName");
        String acc = (obj == null ? "" : (obj + ""));
        student st = d.checkUser(acc);
        int[] active = {0, 1, 2, 3};
        request.setAttribute("u", st);
        request.setAttribute("act", active);
        request.getRequestDispatcher("/VIEW/updateST.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Acc ac = (Acc) ses.getAttribute("user");
        String passad = request.getParameter("passadmin");
        if (passad.equals(ac.getPassWord().trim())) {
            Object obj = request.getParameter("AccName");
            String acc = (obj == null ? "" : (obj + ""));
            String pass = (String) request.getParameter("pass");
            String email = (String) request.getParameter("mail");
            String active = (String) request.getParameter("active");
            d.updateAd(acc, email, pass, Integer.parseInt(active));
        }
        response.sendRedirect("ADServlet");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
