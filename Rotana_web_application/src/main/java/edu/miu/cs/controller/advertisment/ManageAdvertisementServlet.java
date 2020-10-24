package edu.miu.cs.controller.advertisment;

import com.google.gson.Gson;
import edu.miu.cs.dao.advertisement.AdvertisementDao;
import edu.miu.cs.dao.advertisement.IAdvertisementDao;
import edu.miu.cs.domain.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/block-advert")
public class ManageAdvertisementServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(ManageAdvertisementServlet.class.getName());
    private IAdvertisementDao advertisementDao;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        super.init();
        this.advertisementDao = new AdvertisementDao();
        this.gson = new Gson();
    }//

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            if(request.getParameter("advert_id") != null){
                long id = Long.parseLong(request.getParameter("advert_id"));
                Advertisement advertisement = advertisementDao.findById(id);
                if(advertisement.isBlocked())
                    advertisement.setBlocked(Boolean.FALSE);
                else
                    advertisement.setBlocked(Boolean.TRUE);
                Advertisement advertisementObj = advertisementDao.update(advertisement);
                PrintWriter writer = response.getWriter();
                String userJsonString = this.gson.toJson(advertisementObj);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                writer.print(userJsonString);
                writer.flush();
            }else{
                response.sendRedirect("/advertisements");
            }
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }
}
