package edu.miu.cs.controller.admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/admin-logout")
public class LogoutController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LogoutController.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession();
            if(session != null)
                session.invalidate();
            response.sendRedirect("/admin-login");
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }//
    }
}
