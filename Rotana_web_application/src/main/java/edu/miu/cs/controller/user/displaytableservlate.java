//package edu.miu.cs.controller.user;
//
//import edu.miu.cs.domain.User;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//  @WebServlet("/displayontable")
//public class displaytableservlate extends HttpServlet {
//
//       List userlist=new ArrayList<>();
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//          String fname=req.getParameter("firstName");
//          String lname=req.getParameter("lastName");
//          String email=req.getParameter("email");
//          String geneder=req.getParameter("gender");
//        User user=new User(fname,lname,geneder,email);
//         userlist.add(user);
//
//             resp.sendRedirect("displayontable");
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//            req.setAttribute("lists","userlist");
//        RequestDispatcher rr=req.getRequestDispatcher("list-user.jsp");
//
//        rr.forward(req,resp);
//
//    }
//}
