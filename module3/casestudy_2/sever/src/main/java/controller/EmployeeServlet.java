package controller;

import bo.employee_bo.*;
import model.employee.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
        EmployeeBO employeeBO = new EmployeeBOImpl();
        UserBO userBO=new UserBOImpl();
        DivisionBO divisionBO=new DivisionBOImpl();
        EducationDegreeBO educationDegreeBO=new EducationDegreeBOImpl();
        PositionBO positionBO=new PositionBOImpl();

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String actionEmployee = request.getParameter("actionEmployee");
            switch (actionEmployee) {
                case "create":
                    createEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request,response);
                    break;
                case "edit":
                    editEmployee(request,response);
                    break;
                case "find":
                    findEmployeeByName(request,response);
                    break;
                default:
                    break;
            }
        }


    private void findEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String employeeName=request.getParameter("employeeName");
            List<Employee> employeeList=employeeBO.findEmployeeByName(employeeName);
            String action=request.getParameter("action");
            request.setAttribute("action","employee");
            request.setAttribute("employeeList",employeeList);
            request.getRequestDispatcher("display.jsp").forward(request,response);
        }

        private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id=request.getParameter("idEmployee");
            String name=request.getParameter("nameEmployee");
            String birthday=request.getParameter("birthdayEmployee");
            String idCard=request.getParameter("idCardEmployee");
            String salary=request.getParameter("salary");
            String phone=request.getParameter("phoneEmployee");
            String email=request.getParameter("emailEmployee");
            String address=request.getParameter("addressEmployee");
            String positionId=request.getParameter("positionId");
            String educationDegreeId=request.getParameter("educationDegreeId");
            String divisionId=request.getParameter("divisionId");
            String userName=request.getParameter("userName");
            Employee employee=new Employee(id,name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);

            String message = this.employeeBO.editEmployee(employee);
            List<User> userList=userBO.findAllUser();
            List<Division> divisionList=divisionBO.findAllDivision();
            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
            List<Position> positionList=positionBO.findAllPosition();
            request.setAttribute("userList",userList);
            request.setAttribute("divisionList",divisionList);
            request.setAttribute("educationDegreeList",educationDegreeList);
            request.setAttribute("positionList",positionList);
            request.setAttribute("employee", employee);
            request.setAttribute("message", message);
            request.getRequestDispatcher("employee/editEmployee.jsp").forward(request, response);
        }

        private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String idCustomer=request.getParameter("idEmployee");
            employeeBO.deleteEmployee(idCustomer);
            this.displayEmployee(request,response);

        }

        private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name=request.getParameter("nameEmployee");
            String birthday=request.getParameter("birthdayEmployee");
            String idCard=request.getParameter("idCardEmployee");
            String salary=request.getParameter("salary");
            String phone=request.getParameter("phoneEmployee");
            String email=request.getParameter("emailEmployee");
            String address=request.getParameter("addressEmployee");
            String positionId=request.getParameter("positionId");
            String educationDegreeId=request.getParameter("educationDegreeId");
            String divisionId=request.getParameter("divisionId");
            String userName=request.getParameter("userName");
            Employee employee=new Employee(name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);
            String message = this.employeeBO.createEmployee(employee);

            List<User> userList=userBO.findAllUser();
            List<Division> divisionList=divisionBO.findAllDivision();
            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
            List<Position> positionList=positionBO.findAllPosition();
            request.setAttribute("userList",userList);
            request.setAttribute("divisionList",divisionList);
            request.setAttribute("educationDegreeList",educationDegreeList);
            request.setAttribute("positionList",positionList);
            request.setAttribute("employee", employee);
            request.setAttribute("message", message);
            request.getRequestDispatcher("employee/createEmployee.jsp").forward(request, response);
        }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String actionEmployee = request.getParameter("actionEmployee");
            switch (actionEmployee) {
                case "create":
                    showCreateEmployeeForm(request, response);
                    break;
                case "edit":
                    showEditEmployeeForm(request, response);
                    break;
                default:
                    break;
            }

        }

        private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String idEmployee=request.getParameter("idEmployee");
            Employee employee=employeeBO.findEmployeeById(idEmployee);
            List<User> userList=userBO.findAllUser();
            List<Division> divisionList=divisionBO.findAllDivision();
            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
            List<Position> positionList=positionBO.findAllPosition();
            request.setAttribute("userList",userList);
            request.setAttribute("divisionList",divisionList);
            request.setAttribute("educationDegreeList",educationDegreeList);
            request.setAttribute("positionList",positionList);
            request.setAttribute("employee",employee);
                request.getRequestDispatcher("employee/editEmployee.jsp").forward(request, response);
        }

        private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
            List<User> userList=userBO.findAllUser();
            List<Division> divisionList=divisionBO.findAllDivision();
            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
            List<Position> positionList=positionBO.findAllPosition();
            request.setAttribute("userList",userList);
            request.setAttribute("divisionList",divisionList);
            request.setAttribute("educationDegreeList",educationDegreeList);
            request.setAttribute("positionList",positionList);
            try {
                request.getRequestDispatcher("employee/createEmployee.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void displayEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<Employee> employeeList=employeeBO.findAllEmployee();
            String action=request.getParameter("action");
            request.setAttribute("action","employee");
            request.setAttribute("employeeList",employeeList);
            request.getRequestDispatcher("display.jsp").forward(request,response);
        }
}
