package edu.miu.cs.servlet;

import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;
import edu.miu.cs.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/timeline")//
public class TimelineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = Long.parseLong(req.getParameter("rf"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        IUserDao userDao = new UserDao();
        PostService postService = new PostService();
        User timelimeUser = userDao.findById(userId);
        req.setAttribute("timelineUser",timelimeUser);
        req.setAttribute("posts", postService.getPostsByUser(timelimeUser));
        boolean isSelf = false;
        if(user.getId()==timelimeUser.getId()){
            isSelf = true;
        }
        req.setAttribute("isSelf",isSelf);
        req.getRequestDispatcher("views/user/timeline.jsp").forward(req,resp);
    }
}
