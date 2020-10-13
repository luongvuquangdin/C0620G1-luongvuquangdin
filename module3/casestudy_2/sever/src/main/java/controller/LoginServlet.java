package controller;

import bo.employee_bo.UserBO;
import bo.employee_bo.UserBOImpl;
import model.employee.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserBO userBO=new UserBOImpl();
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user=new User(username,password);
            String message=userBO.findUser(user);
            if (message.equals("OK")){
                response.sendRedirect("/home");
            }else {
                request.setAttribute("message","error");
                request.getRequestDispatcher("login.jsp").forward(request,response);}
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           response.sendRedirect("login.jsp");
        }
}
