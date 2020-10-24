package edu.miu.cs.servlet;

import edu.miu.cs.dao.user.FollowDao;
import edu.miu.cs.dao.user.IFollowDao;
import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.Follow;
import edu.miu.cs.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/follow")
public class FollowUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("user");

        long followingid = Long.valueOf(req.getParameter("user"));

        //data access//
        IUserDao userDao = new UserDao();
        IFollowDao followDao = new FollowDao();

        Follow follow = new Follow();
        follow.setFollower(user);
        follow.setFollowed(userDao.findById(followingid));
        followDao.create(follow);

        PrintWriter out = resp.getWriter();
        out.write("follow successful");
    }
}
