package edu.miu.cs.controller.advertisment;

import edu.miu.cs.dao.advertisement.AdvertisementDao;
import edu.miu.cs.dao.advertisement.IAdvertisementDao;
import edu.miu.cs.domain.Advertisement;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/advertisements")
public class AdvertisementServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(AdvertisementServlet.class.getName());
    private String UPLOAD_DIRECTORY;
    private IAdvertisementDao advertisementDao;

    @Override
    public void init() throws ServletException {
        super.init();
        this.advertisementDao = new AdvertisementDao();
    }//

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Advertisement> advertisements = advertisementDao.findAll();
            request.setAttribute("advertisements", advertisements);
            request.getRequestDispatcher("advertisements.jsp").forward(request, response);
            response.sendRedirect("/advertisements");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("application/json");
            UPLOAD_DIRECTORY = request.getServletContext().getInitParameter("advertisements");
            String imageName = "";
            Map<String, String> params = new HashMap<>();
            if (ServletFileUpload.isMultipartContent(request)) {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString();
                        params.put(name, value);
                    } else {
                        String name = new File(item.getName()).getName();
                        imageName = name;
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                request.setAttribute("message", "File Uploaded Successfully");
            } else {
                request.setAttribute("message",
                        "Sorry this Servlet only handles file upload request");
            }
            String title = params.get("title");
            String company = params.get("company");
            String link = params.get("link");
            Advertisement advertisement = new Advertisement(title, company, imageName, Boolean.FALSE, link);
            advertisementDao.create(advertisement);
            response.sendRedirect("/advertisements");
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
        }
    }

}
