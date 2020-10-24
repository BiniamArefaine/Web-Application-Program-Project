package edu.miu.cs.controller;

import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            resp.sendRedirect("/home");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }//
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String remember = req.getParameter("remember_me");
            IUserDao userDao = new UserDao();
            List<User> users = userDao.findAll();
            User userObj = null;
            for (User user : users) {
                if (user.getEmail().equals(username.trim())
                        && user.getPassword().equals(password.trim())) {
                    userObj = user;
                    break;
                }
            }
            if (userObj == null) {
                resp.sendRedirect("/");
            } else {
                if (remember != null) {
                    Cookie cookieUsername = new Cookie("cookieUsername", userObj.getEmail());
                    Cookie cookiePassword = new Cookie("cookiePassword", userObj.getPassword());
                    Cookie cookieRememberMe = new Cookie("cookieRememberMe", remember.trim());
                    cookieUsername.setMaxAge(60 * 60 * 24 * 30);
                    cookiePassword.setMaxAge(60 * 60 * 24 * 30);
                    cookieRememberMe.setMaxAge(60 * 60 * 24 * 30);
                    resp.addCookie(cookieUsername);
                    resp.addCookie(cookiePassword);
                    resp.addCookie(cookieRememberMe);
                }
                HttpSession session = req.getSession();
                session.setAttribute("authenticated", userObj);
                req.setAttribute("user", userObj);
                doGet(req, resp);
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }

    }
}

