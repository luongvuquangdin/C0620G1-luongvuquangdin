package controller;

import bo.contract_bo.ContractBO;
import bo.contract_bo.ContractBOImpl;
import bo.contract_detail_bo.AttachServiceBO;
import bo.contract_detail_bo.AttachServiceBOImpl;
import bo.contract_detail_bo.ContractDetailBO;
import bo.contract_detail_bo.ContractDetailBOImpl;
import model.contract.Contract;
import model.contract_detail.AttachService;
import model.contract_detail.ContractDetail;
import model.customer.Customer;
import model.employee.Employee;
import model.service.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet",urlPatterns = "/contractDetail")
public class ContractDetailServlet extends HttpServlet {
    ContractDetailBO contractDetailBO=new ContractDetailBOImpl();
    AttachServiceBO attachServiceBO=new AttachServiceBOImpl();
    ContractBO contractBO=new ContractBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionContractDetail=request.getParameter("actionContractDetail");
        if (actionContractDetail==null){
            actionContractDetail="";
        }
        if (actionContractDetail.equals("create")){
            CreateContractDetail(request,response);
        }


    }

    private void CreateContractDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quantity=request.getParameter("quantity");
        String contractId=request.getParameter("contractId");
        String attachServiceId=request.getParameter("attachServiceId");
        ContractDetail contractDetail=new ContractDetail(quantity,contractId,attachServiceId);
        String message=this.contractDetailBO.createContractDetail(contractDetail);

        List<Contract> contractList=this.contractBO.findAllContract();
        List<AttachService> attachServiceList=this.attachServiceBO.findAllAttachService();
        request.setAttribute("message",message);
        request.setAttribute("contractDetail",contractDetail);
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServiceList",attachServiceList);
        request.getRequestDispatcher("contract_detail/createContractDetail.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionContractDetail=request.getParameter("actionContractDetail");
        if (actionContractDetail==null){
            actionContractDetail="";
        }
        if (actionContractDetail.equals("create")){
            showCreateContractDetailForm(request,response);
        }

    }

    private void showCreateContractDetailForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList=this.contractBO.findAllContract();
        List<AttachService> attachServiceList=this.attachServiceBO.findAllAttachService();
        request.setAttribute("contractList",contractList);
        request.setAttribute("attachServiceList",attachServiceList);
        request.getRequestDispatcher("contract_detail/createContractDetail.jsp").forward(request,response);
    }
}
