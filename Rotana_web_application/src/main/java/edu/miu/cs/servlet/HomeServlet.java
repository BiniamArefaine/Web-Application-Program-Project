package edu.miu.cs.servlet;


import edu.miu.cs.dao.post.INotificationDao;
import edu.miu.cs.dao.post.NotificationDao;

import edu.miu.cs.dao.advertisement.AdvertisementDao;
import edu.miu.cs.dao.advertisement.IAdvertisementDao;
import edu.miu.cs.domain.Advertisement;

import edu.miu.cs.domain.User;
import edu.miu.cs.service.PostService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "home", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(HomeServlet.class.getName());
    private IAdvertisementDao advertisementDao;
    
    @Override
    public void init() throws ServletException {
        super.init();
        this.advertisementDao = new AdvertisementDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {

            // add testing date
            PostService postService = new PostService();
            INotificationDao notificationDao = new NotificationDao();
            HttpSession session = req.getSession();
            User user;

            List<Advertisement> advertisements = advertisementDao.findAll();
            req.setAttribute("advertisements", advertisements);

            if (session != null) {

                user = (User) session.getAttribute("authenticated");
                //req.setAttribute("user", user);

                session.setAttribute("user",user);

                session.setAttribute("notifications",notificationDao.findAll());

                session.setAttribute("posts",postService.getPostsUserHome(user));

                RequestDispatcher rd = req.getRequestDispatcher("views/user/home2.jsp");
                rd.forward(req, resp);
            } else {
                resp.sendRedirect("");
            }
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }

    }//
}
