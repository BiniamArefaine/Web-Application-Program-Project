package edu.miu.cs.servlet;

import com.google.gson.Gson;
import edu.miu.cs.dao.post.INotificationDao;
import edu.miu.cs.dao.post.NotificationDao;
import edu.miu.cs.domain.Notification;
import edu.miu.cs.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/notifications")
public class NotificationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        INotificationDao notificationDao = new NotificationDao();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        List<Notification> notifications =notificationDao.getNotificationsByUser(user);
        req.setAttribute("notifications",notifications);
        notificationDao.updateNotifications(notifications);
        req.getRequestDispatcher("views/user/notifications.jsp").forward(req,resp);
    }//

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        INotificationDao notificationDao = new NotificationDao();
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");
        List<Notification> notifications =notificationDao.getNotificationsByUser(user);
        Gson gn = new Gson();
        resp.setContentType("application/json");
        String notJson = gn.toJson(notifications);
        PrintWriter out = resp.getWriter();
        out.write(notJson);
    }
}
