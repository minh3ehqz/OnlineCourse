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
import java.util.ArrayList;
import model.*;

/**
 *
 * @author WIN
 */
public class DetailServlet extends HttpServlet {

    classDAO cl = new classDAO();
    DAO dao = new DAO();
    conditionDAO co = new conditionDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classid = request.getParameter("classid");
        ClassR cls = cl.classbyIDM(classid);
        student mentor = dao.loadbyID(cls.getMentor());
        ArrayList<String> c = co.classCondition(classid);
        ArrayList<ClassR> clr = new ArrayList<>();
        for (String str : c) {
            clr.add(cl.classbyID(str));
        }

        if (clr.isEmpty()) {
            request.setAttribute("condi", null);
        } else {
            request.setAttribute("condi", clr);
        }
        request.setAttribute("cls", cls);
        request.setAttribute("mt", mentor);
        request.getRequestDispatcher("VIEW/detail.jsp").forward(request, response);
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
