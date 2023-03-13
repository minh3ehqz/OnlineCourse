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
import java.util.ArrayList;
import java.util.List;
import model.*;

public class CourseServlet extends HttpServlet {

    classDAO cd = new classDAO();
    processDAO pr = new processDAO();
    DAO d = new DAO();
    conditionDAO co = new conditionDAO();
    
    public void coulist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int count = cd.getTotalClass();
            int endpage = count / 10;
            if (count % 10 != 0) {
                endpage++;
            }
            String Stringpage = request.getParameter("index");
            if (Stringpage == null) {
                Stringpage = "1";
            } else if (Integer.parseInt(Stringpage) > endpage) {
                Stringpage = String.valueOf(endpage);
            } else if (Integer.parseInt(Stringpage) < 1) {
                Stringpage = "1";
            }
            int page = Integer.parseInt(Stringpage);
            List<ClassR> list = cd.pageindex(page);

            request.setAttribute("page", page);
            request.setAttribute("listClass", list);
            request.setAttribute("course", cd);
            request.setAttribute("endp", endpage);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        cd.loadClass();
        student user = null;
        HttpSession ses = request.getSession(false);
        Object obj = request.getParameter("id");
        String id = (obj == null ? "" : (obj + ""));
        obj = request.getParameter("search");
        String s = (obj == null ? "" : (obj + ""));
        Acc ac = (Acc) ses.getAttribute("user");
        if (ac == null) {
            coulist(request, response);
        } else {
            user = d.checkUser(ac.getUserName());
            if (user.getActive() == 3) {
                request.setAttribute("listClass", cd.loadMentor(user.getID()));
            }else{
                coulist(request, response);
            }
        }

        if (s.length() != 0) {
            List<ClassR> list = cd.search(s);
            request.setAttribute("listClass", list);
        } else {
            if (ses != null) {
                String st = (String) ses.getAttribute("name");
                if (id.length() != 0) {
                    ArrayList<String> cs = co.classCondition(id);
                    if (cs.isEmpty()) {
                        pr.insert(id, d.checkUser(st).getID());
                    } else {
                        process checkpr;
                        boolean check = true;
                        for (String str : cs) {
                            checkpr = pr.checkCon(user.getID(), str);
                            if (checkpr == null) {
                                check = false;
                            }
                        }
                        request.setAttribute("check", check);
                        if (check) {
                            pr.insert(id, d.checkUser(st).getID());
                        }
                    }
                }
            }

        }
        request.getRequestDispatcher("VIEW/course.jsp").forward(request, response);

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
