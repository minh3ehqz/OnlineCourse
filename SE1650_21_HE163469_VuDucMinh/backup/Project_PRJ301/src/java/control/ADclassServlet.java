/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import DAL.classDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Acc;
import model.ClassR;
import model.student;

/**
 *
 * @author WIN
 */

public class ADclassServlet extends HttpServlet {
    classDAO classd = new classDAO();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        Object obj = request.getParameter("type"); 
        String type = (obj == null ? "" : (obj + ""));
        obj = request.getParameter("id");
        String id = (obj == null ? "" : (obj + ""));
        if (type.equals("2") && id.length() != 0) {
            classd.deleteClass(id);
        }
        
        Acc ac = (Acc) ses.getAttribute("user");
        if (ac.getActive() == 2) {
           int count = classd.getTotalClass();
        int endpage = count / 10;
        if (count % 10 != 0) {
            endpage++;
        }

        String Stringpage = request.getParameter("index");
        if (Stringpage == null) {
            Stringpage = "1";
        } else if (Integer.parseInt(Stringpage) > endpage) {
            Stringpage = String.valueOf(endpage);
        }
        int page = Integer.parseInt(Stringpage);
        List<ClassR> list = classd.pageindex(page);

        request.setAttribute("page", page);
        request.setAttribute("listClass", list);
        request.setAttribute("user", ses.getAttribute("userName"));
        request.setAttribute("endp", endpage);
            
        }
        request.getRequestDispatcher("VIEW/adminClass.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
