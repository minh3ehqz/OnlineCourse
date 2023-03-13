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
import java.util.List;
import model.*;

/**
 *
 * @author WIN
 */
public class ADServlet extends HttpServlet {

    DAO d = new DAO();
    classDAO classd = new classDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        Object obj = request.getParameter("type");
        String type = (obj == null ? "" : (obj + ""));
        obj = request.getParameter("id");
        String id = (obj == null ? "" : (obj + ""));
        if (type.equals("2") && id.length() != 0) {
            d.delete(id);
        }

        Acc ac = (Acc) ses.getAttribute("user");
        if (ac.getActive() == 2) {
            d.loadStudent();
            String Stringpage = request.getParameter("index");
            int count = d.getTotalST();
            int endpage = count / 10;
            if (count % 10 != 0) {
                endpage++;
            }
            if (Stringpage == null) {
                Stringpage = "1";
            } else if (Integer.parseInt(Stringpage) > endpage) {
                Stringpage = String.valueOf(endpage);
            }
            int page = Integer.parseInt(Stringpage);
            List<student> lst = d.pageADindex(page);

            request.setAttribute("listSt", lst);
            request.setAttribute("page", page);
            request.setAttribute("endp", endpage);
            request.setAttribute("dao", d);
            request.getRequestDispatcher("VIEW/admin.jsp").forward(request, response);
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
