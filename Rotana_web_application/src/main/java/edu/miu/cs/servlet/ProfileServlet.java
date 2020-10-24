package edu.miu.cs.servlet;

import com.google.gson.Gson;
import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ProfileServlet.class.getName());
    private IUserDao dao;
    private Gson gson = new Gson();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dao = new UserDao();
    }//

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new UserDao();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            User user;
            if (request.getSession() != null) {
                user = (User) request.getSession().getAttribute("user");
                request.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("views/user/profile.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("/");
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            User user = userprofile(req);
            session.setAttribute("user", user);
            dao.update(user);
            resp.sendRedirect("profile");
            PrintWriter writer = resp.getWriter();
            String userJsonString = this.gson.toJson(user);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            writer.print(userJsonString);
            writer.flush();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }


    }

    private User userprofile(HttpServletRequest req) {
        String fname = req.getParameter("firstname");
        String lname = req.getParameter("lastname");
        String email = req.getParameter("email");
        String phone = req.getParameter("myphone");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String city = req.getParameter("cityyy");
        String country = req.getParameter("country");
        String gender = req.getParameter("gender");
        return new User(fname, lname, email, phone, day, month, year, city, country, gender);
    }

}
