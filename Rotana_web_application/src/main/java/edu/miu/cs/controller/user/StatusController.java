package edu.miu.cs.controller.user;

import com.google.gson.Gson;
import edu.miu.cs.dao.user.IUserDao;
import edu.miu.cs.dao.user.UserDao;
import edu.miu.cs.domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/change-status")
public class StatusController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(StatusController.class.getName());
    private IUserDao dao;
    private Gson gson = new Gson();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new UserDao();
    }//

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
       try{
           String userId = request.getParameter("user_id");
           long id = Long.parseLong(userId);
           User user =  dao.findById(id);
           if(user.isActive())
               user.setActive(Boolean.FALSE);
           else
               user.setActive(Boolean.TRUE);
           User userObj = dao.create(user);
           PrintWriter writer = response.getWriter();
           String userJsonString = this.gson.toJson(userObj);
           response.setContentType("application/json");
           response.setCharacterEncoding("UTF-8");
           writer.print(userJsonString);
           writer.flush();
       }catch (Exception ex){
           LOGGER.log(Level.SEVERE, ex.getMessage());
       }
    }
}
