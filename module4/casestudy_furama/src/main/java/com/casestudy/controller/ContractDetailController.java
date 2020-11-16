package com.casestudy.controller;

import com.casestudy.entity.contract.Contract;
import com.casestudy.entity.contract_detail.ContractDetail;
import com.casestudy.service.contract_detail_service.AttachServiceOfService;
import com.casestudy.service.contract_detail_service.ContractDetailService;
import com.casestudy.service.contract_service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/contractDetails")
public class ContractDetailController {
    @Autowired
    ContractDetailService contractDetailService;
    @Autowired
    AttachServiceOfService attachServiceOfService;
    @Autowired
    ContractService contractService;

    @GetMapping
    public String goDisplayContractDetailList(Model model){
        model.addAttribute("contractDetailList",this.contractDetailService.findAllContractDetail());
        return "contract_detail/contractDetailDisplay";
    }

    @GetMapping("/create")
    public String goCreateEmployee(Model model){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("contractList",this.contractService.findAllContract());
        model.addAttribute("attachList",this.attachServiceOfService.findAllAttachService());
        return "contract_detail/createContractDetail";
    }

    @PostMapping("/create")
    public String goCreateEmployee(@Validated @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult, Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("contractDetail",contractDetail);
            model.addAttribute("contractList",this.contractService.findAllContract());
            model.addAttribute("attachList",this.attachServiceOfService.findAllAttachService());
            return "contract_detail/createContractDetail";
        }
        this.contractDetailService.createContractDetail(contractDetail);
        return "redirect:/contractDetails";
    }


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionContractDetail=request.getParameter("actionContractDetail");
//        if (actionContractDetail==null){
//            actionContractDetail="";
//        }
//        if (actionContractDetail.equals("create")){
//            CreateContractDetail(request,response);
//        }
//
//
//    }
//
//    private void CreateContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String quantity=request.getParameter("quantity");
//        String contractId=request.getParameter("contractId");
//        String attachServiceId=request.getParameter("attachServiceId");
//        ContractDetail contractDetail=new ContractDetail(quantity,contractId,attachServiceId);
//        String message=this.contractDetailBO.createContractDetail(contractDetail);
//
//        List<Contract> contractList=this.contractBO.findAllContract();
//        List<AttachService> attachServiceList=this.attachServiceBO.findAllAttachService();
//        request.setAttribute("message",message);
//        request.setAttribute("contractDetail",contractDetail);
//        request.setAttribute("contractList",contractList);
//        request.setAttribute("attachServiceList",attachServiceList);
//        request.getRequestDispatcher("contract_detail/createContractDetail.html").forward(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String actionContractDetail=request.getParameter("actionContractDetail");
//        if (actionContractDetail==null){
//            actionContractDetail="";
//        }
//        if (actionContractDetail.equals("create")){
//            showCreateContractDetailForm(request,response);
//        }
//
//    }
//
//    private void showCreateContractDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Contract> contractList=this.contractBO.findAllContract();
//        List<AttachService> attachServiceList=this.attachServiceBO.findAllAttachService();
//        request.setAttribute("contractList",contractList);
//        request.setAttribute("attachServiceList",attachServiceList);
//        request.getRequestDispatcher("contract_detail/createContractDetail.html").forward(request,response);
//    }
}
