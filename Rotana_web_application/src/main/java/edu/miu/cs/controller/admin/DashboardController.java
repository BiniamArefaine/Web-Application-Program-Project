package edu.miu.cs.controller.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/admin-dashboard")
public class DashboardController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(DashboardController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession();
            if(session == null){
                response.sendRedirect("/admin/login");
            }else{
                String authenticate = (String) session.getAttribute("admin");
                if(authenticate.equals("admin")) {
                    request.getRequestDispatcher("admin-dashboard.jsp")
                            .forward(request, response);
                    response.sendRedirect("/admin-dashboard");
                }
            }//
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }
}
