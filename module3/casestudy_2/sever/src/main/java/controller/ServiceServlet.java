package controller;

import bo.boservice.*;
import dao.daocustomer.ConnectDatabase;
import model.service.RentType;
import model.service.Service;
import model.service.ServiceType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO=new ServiceBOImpl();
    ServiceTypeBO serviceTypeBO=new ServiceTypeBOImpl();
    RentTypeBO rentTypeBO=new RentTypeBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionService=request.getParameter("actionService");
        if (actionService==null){
            actionService="";
        }
        if (actionService.equals("create")){
            this.createService(request,response);
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("idService");
        String name=request.getParameter("nameService");
        String area=request.getParameter("areaService");
        String cost=request.getParameter("serviceCost");
        String maxPeople=request.getParameter("maxPeople");
        String standardRoom=request.getParameter("standardRoom");
        String descriptionOtherConvenience=request.getParameter("description");
        String poolArea=request.getParameter("poolAreaService");
        String numberOfFloors=request.getParameter("numberOfFloorsService");
        String rentTypeId=request.getParameter("rentTypeId");
        String typeId=request.getParameter("serviceTypeId");
        Service service = new Service(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeId,typeId);
        String message=this.serviceBO.createService(service);
        List<ServiceType> serviceTypeList=serviceTypeBO.findAllServiceType();
        List<RentType> rentTypeList=rentTypeBO.findAllRentType();
        request.setAttribute("serviceTypeList",serviceTypeList);
        request.setAttribute("rentTypeList",rentTypeList);
        request.setAttribute("message",message);
        request.setAttribute("service",service);
        request.getRequestDispatcher("service/createService.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionService=request.getParameter("actionService");
        if (actionService==null){
            actionService="";
        }
        if (actionService.equals("create")){
            this.showCreateServiceForm(request,response);
        }
    }

    private void showCreateServiceForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ServiceType> serviceTypeList=serviceTypeBO.findAllServiceType();
        List<RentType> rentTypeList=rentTypeBO.findAllRentType();
        request.setAttribute("serviceTypeList",serviceTypeList);
        request.setAttribute("rentTypeList",rentTypeList);
        request.getRequestDispatcher("service/createService.jsp").forward(request,response);
    }
}
