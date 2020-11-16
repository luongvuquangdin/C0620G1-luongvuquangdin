package com.casestudy.controller;

import com.casestudy.entity.customer.Customer;
import com.casestudy.entity.service.ServiceOfFurama;
import com.casestudy.service.service_services.RentTypeService;
import com.casestudy.service.service_services.ServiceOfFuramaService;
import com.casestudy.service.service_services.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/services")
public class ServiceController extends HttpServlet {
    @Autowired
    ServiceOfFuramaService serviceOfFuramaService;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping
    public String goDisplayServiceList(@PageableDefault(size = 2) Pageable pageable,Model model){
        model.addAttribute("serviceList",this.serviceOfFuramaService.findAllService(pageable));
        return "service/serviceDisplay";
    }

    @GetMapping("/create")
    public String goCreateService(Model model){
        model.addAttribute("service",new ServiceOfFurama());
        model.addAttribute("rentTypeServiceList",this.rentTypeService.findAllRentType());
        model.addAttribute("serviceTypeServiceList",this.serviceTypeService.findAllServiceType());
        return "service/createService";
    }

    @PostMapping("/create")
    public String createService(@Validated @ModelAttribute ServiceOfFurama serviceOfFurama, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("service",serviceOfFurama);
            model.addAttribute("rentTypeServiceList",this.rentTypeService.findAllRentType());
            model.addAttribute("serviceTypeServiceList",this.serviceTypeService.findAllServiceType());
            return "service/createService";
        }
        this.serviceOfFuramaService.createService(serviceOfFurama);
        return "redirect:/services";
    }
//    ServiceBO serviceBO=new ServiceBOImpl();
//    ServiceTypeBO serviceTypeBO=new ServiceTypeBOImpl();
//    RentTypeBO rentTypeBO=new RentTypeBOImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionService=request.getParameter("actionService");
//        if (actionService==null){
//            actionService="";
//        }
//        if (actionService.equals("create")){
//            this.createService(request,response);
//        }
//    }
//
//    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String id=request.getParameter("idService");
//        String name=request.getParameter("nameService");
//        String area=request.getParameter("areaService");
//        String cost=request.getParameter("serviceCost");
//        String maxPeople=request.getParameter("maxPeople");
//        String standardRoom=request.getParameter("standardRoom");
//        String descriptionOtherConvenience=request.getParameter("description");
//        String poolArea=request.getParameter("poolAreaService");
//        String numberOfFloors=request.getParameter("numberOfFloorsService");
//        String rentTypeId=request.getParameter("rentTypeId");
//        String typeId=request.getParameter("serviceTypeId");
//        Service service = new Service(id,name,area,cost,maxPeople,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors,rentTypeId,typeId);
//        String message=this.serviceBO.createService(service);
//        List<ServiceType> serviceTypeList=serviceTypeBO.findAllServiceType();
//        List<RentType> rentTypeList=rentTypeBO.findAllRentType();
//        request.setAttribute("serviceTypeList",serviceTypeList);
//        request.setAttribute("rentTypeList",rentTypeList);
//        request.setAttribute("message",message);
//        request.setAttribute("service",service);
//        request.getRequestDispatcher("service/createService.html").forward(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionService=request.getParameter("actionService");
//        if (actionService==null){
//            actionService="";
//        }
//        if (actionService.equals("create")){
//            this.showCreateServiceForm(request,response);
//        }
//    }
//
//    private void showCreateServiceForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        List<ServiceType> serviceTypeList=serviceTypeBO.findAllServiceType();
//        List<RentType> rentTypeList=rentTypeBO.findAllRentType();
//        request.setAttribute("serviceTypeList",serviceTypeList);
//        request.setAttribute("rentTypeList",rentTypeList);
//        request.getRequestDispatcher("service/createService.html").forward(request,response);
//    }
}
