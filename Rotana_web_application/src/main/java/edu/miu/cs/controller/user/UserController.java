package edu.miu.cs.controller.user;

import com.google.gson.Gson;
import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/users")
public class UserController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private IUserDao dao;
    private Gson gson = new Gson();

    @Override
    public void init() throws ServletException {
        super.init();
        dao = new UserDao();
    }//

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            List<User> users = dao.findAll();
            request.setAttribute("users", users);
            request.getRequestDispatcher("list-users.jsp")
                    .forward(request, response);
            response.sendRedirect("/users");
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try{
            User user = userObj(request);
            dao.create(user);
            PrintWriter writer = response.getWriter();
            String userJsonString = this.gson.toJson(user);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            writer.print(userJsonString);
            writer.flush();
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    private User userObj(HttpServletRequest request){
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String access = "user";
        return new User(firstName, lastName, email, password, access, gender);
    }
}
