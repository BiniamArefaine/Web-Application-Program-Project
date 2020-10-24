package edu.miu.cs.controller.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/admin-login")
public class LoginController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());
    private static final String ADMIN = "admin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("admin-login.jsp").forward(request, response);
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }//
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean authenticated = (username.equals(ADMIN) && password.equals(ADMIN));
            if (authenticated) {
                HttpSession session = request.getSession();
                session.setAttribute(ADMIN, ADMIN);
                response.sendRedirect("/admin-dashboard");
            }else
                response.sendRedirect("/admin-login");
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }
}
