package controller;

import bo.ProductBo;
import bo.ProductImpl;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",urlPatterns = {"","/products"})
public class ProductServlet extends HttpServlet {
    ProductBo productBo=new ProductImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("createProduct");
        if (action == null){
            action="";
        }
        switch (action){
            case "create":
                break;
            default:
                List<Product> productList=this.productBo.findAll();
                request.setAttribute("productList",productList);
                request.getRequestDispatcher("list.jsp").forward(request,response);
                break;
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create":
                response.sendRedirect("create.jsp");
                break;
            default:
                List<Product> productList=this.productBo.findAll();
                request.setAttribute("productList",productList);
                request.getRequestDispatcher("list.jsp").forward(request,response);
                break;
        }


    }
}
