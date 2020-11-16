package com.casestudy.controller;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import java.util.Optional;


@Controller
public class LoginController extends HttpServlet {
    @GetMapping("/login")
    public String goLogin(@RequestParam Optional<Boolean> error,
                          @CookieValue(name = "rememberMeCookie",defaultValue = "") String username, Model model){
        if (error.isPresent()){
                model.addAttribute("error","Password or UserName fail");
        }
        model.addAttribute("username",username);
        return "login" ;
    }
    @GetMapping("/403")
    public String goError(){
        return "403";
    }
//    UserBO userBO=new UserBOImpl();
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            User user=new User(username,password);
//            String message=userBO.findUser(user);
//            if (message.equals("OK")){
//                response.sendRedirect("/home");
//            }else {
//                request.setAttribute("message","error");
//                request.getRequestDispatcher("login.html").forward(request,response);}
//        }
//
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//           response.sendRedirect("login.html");
//        }
}
