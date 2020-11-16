package com.casestudy.controller;


import com.casestudy.entity.employee.Employee;
import com.casestudy.entity.employee.User;
import com.casestudy.service.employee_service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;
    @Autowired
    DivisionService divisionService;
    @Autowired
    EducationDegreeService educationDegreeService;
    @Autowired
    PositionService positionService;
    @Autowired
    RoleService roleService;


    @GetMapping
    public String goDisplayEmployeeList(@PageableDefault(size = 3) Pageable pageable,@RequestParam Optional<String> keyWord,Model model){
        String keyWord1="";
        if (keyWord.isPresent()){
            keyWord1=keyWord.get();
            model.addAttribute("employeeList",this.employeeService.findEmployeeByName(keyWord1,pageable));
        }else model.addAttribute("employeeList",this.employeeService.findAllEmployee(pageable));
        model.addAttribute("keyWord",keyWord1);
        return "employee/employeeDisplay";
    }


    @GetMapping("/create")
    public String goCreateEmployee(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("user",new User());
        model.addAttribute("positionList",this.positionService.findAllPosition());
        model.addAttribute("divisionList",this.divisionService.findAllDivision());
        model.addAttribute("educationDegreeList",this.educationDegreeService.findAllEducationDegree());
        model.addAttribute("roleList",this.roleService.findAll());
        return "employee/createEmployee";
    }

    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute Employee employee, BindingResult bindingResult,
                                 @ModelAttribute User user,Model model){
        for (User user1:this.userService.findAllUser()){
            if (user1.getUserName().equals(user.getUserName())){
                model.addAttribute("message","username was exist");
                break;
            }
        }
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employee",employee);
            model.addAttribute("user",user);
            model.addAttribute("positionList",this.positionService.findAllPosition());
            model.addAttribute("divisionList",this.divisionService.findAllDivision());
            model.addAttribute("educationDegreeList",this.educationDegreeService.findAllEducationDegree());
            model.addAttribute("roleList",this.roleService.findAll());
            return "employee/createEmployee";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        this.userService.createUser(user);
        employee.setUser(user);
        this.employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer idOfCustomer){
        this.userService.deleteUser(this.employeeService.findEmployeeById(idOfCustomer).getUser());
        return "redirect:/employees";
    }

    @GetMapping("/edit")
    public String goEditEmployee(@RequestParam Integer id,Model model){
        model.addAttribute("employee",this.employeeService.findEmployeeById(id));
        model.addAttribute("positionList",this.positionService.findAllPosition());
        model.addAttribute("divisionList",this.divisionService.findAllDivision());
        model.addAttribute("educationDegreeList",this.educationDegreeService.findAllEducationDegree());
        return "employee/editEmployee";
    }

    @PostMapping("/edit")
    public String editEmployee(@Validated @ModelAttribute Employee employee,BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employee",employee);
            model.addAttribute("positionList",this.positionService.findAllPosition());
            model.addAttribute("divisionList",this.divisionService.findAllDivision());
            model.addAttribute("educationDegreeList",this.educationDegreeService.findAllEducationDegree());
            return "employee/editEmployee";
        }
        this.employeeService.editEmployee(employee);
        return "redirect:/employees";
    }


//
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String actionEmployee = request.getParameter("actionEmployee");
//            switch (actionEmployee) {
//                case "create":
//                    createEmployee(request, response);
//                    break;
//                case "delete":
//                    deleteEmployee(request,response);
//                    break;
//                case "edit":
//                    editEmployee(request,response);
//                    break;
//                case "find":
//                    findEmployeeByName(request,response);
//                    break;
//                default:
//                    break;
//            }
//        }
//
//
//    private void findEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String employeeName=request.getParameter("employeeName");
//            List<Employee> employeeList=employeeBO.findEmployeeByName(employeeName);
//            String action=request.getParameter("action");
//            request.setAttribute("action","employee");
//            request.setAttribute("employeeList",employeeList);
//            request.getRequestDispatcher("display.html").forward(request,response);
//        }
//
//        private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String id=request.getParameter("idEmployee");
//            String name=request.getParameter("nameEmployee");
//            String birthday=request.getParameter("birthdayEmployee");
//            String idCard=request.getParameter("idCardEmployee");
//            String salary=request.getParameter("salary");
//            String phone=request.getParameter("phoneEmployee");
//            String email=request.getParameter("emailEmployee");
//            String address=request.getParameter("addressEmployee");
//            String positionId=request.getParameter("positionId");
//            String educationDegreeId=request.getParameter("educationDegreeId");
//            String divisionId=request.getParameter("divisionId");
//            String userName=request.getParameter("userName");
//            Employee employee=new Employee(id,name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);
//
//            String message = this.employeeBO.editEmployee(employee);
//            List<User> userList=userBO.findAllUser();
//            List<Division> divisionList=divisionBO.findAllDivision();
//            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
//            List<Position> positionList=positionBO.findAllPosition();
//            request.setAttribute("userList",userList);
//            request.setAttribute("divisionList",divisionList);
//            request.setAttribute("educationDegreeList",educationDegreeList);
//            request.setAttribute("positionList",positionList);
//            request.setAttribute("employee", employee);
//            request.setAttribute("message", message);
//            request.getRequestDispatcher("employee/editEmployee.html").forward(request, response);
//        }
//
//        private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String idCustomer=request.getParameter("idEmployee");
//            employeeBO.deleteEmployee(idCustomer);
//            this.displayEmployee(request,response);
//
//        }
//
//        private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String name=request.getParameter("nameEmployee");
//            String birthday=request.getParameter("birthdayEmployee");
//            String idCard=request.getParameter("idCardEmployee");
//            String salary=request.getParameter("salary");
//            String phone=request.getParameter("phoneEmployee");
//            String email=request.getParameter("emailEmployee");
//            String address=request.getParameter("addressEmployee");
//            String positionId=request.getParameter("positionId");
//            String educationDegreeId=request.getParameter("educationDegreeId");
//            String divisionId=request.getParameter("divisionId");
//            String userName=request.getParameter("userName");
//            Employee employee=new Employee(name,birthday,idCard,salary,phone,email,address,positionId,educationDegreeId,divisionId,userName);
//            String message = this.employeeBO.createEmployee(employee);
//
//            List<User> userList=userBO.findAllUser();
//            List<Division> divisionList=divisionBO.findAllDivision();
//            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
//            List<Position> positionList=positionBO.findAllPosition();
//            request.setAttribute("userList",userList);
//            request.setAttribute("divisionList",divisionList);
//            request.setAttribute("educationDegreeList",educationDegreeList);
//            request.setAttribute("positionList",positionList);
//            request.setAttribute("employee", employee);
//            request.setAttribute("message", message);
//            request.getRequestDispatcher("employee/createEmployee.html").forward(request, response);
//        }
//
//        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String actionEmployee = request.getParameter("actionEmployee");
//            switch (actionEmployee) {
//                case "create":
//                    showCreateEmployeeForm(request, response);
//                    break;
//                case "edit":
//                    showEditEmployeeForm(request, response);
//                    break;
//                default:
//                    break;
//            }
//
//        }
//
//        private void showEditEmployeeForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String idEmployee=request.getParameter("idEmployee");
//            Employee employee=employeeBO.findEmployeeById(idEmployee);
//            List<User> userList=userBO.findAllUser();
//            List<Division> divisionList=divisionBO.findAllDivision();
//            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
//            List<Position> positionList=positionBO.findAllPosition();
//            request.setAttribute("userList",userList);
//            request.setAttribute("divisionList",divisionList);
//            request.setAttribute("educationDegreeList",educationDegreeList);
//            request.setAttribute("positionList",positionList);
//            request.setAttribute("employee",employee);
//                request.getRequestDispatcher("employee/editEmployee.html").forward(request, response);
//        }
//
//        private void showCreateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
//            List<User> userList=userBO.findAllUser();
//            List<Division> divisionList=divisionBO.findAllDivision();
//            List<EducationDegree> educationDegreeList=educationDegreeBO.findAllEducationDegree();
//            List<Position> positionList=positionBO.findAllPosition();
//            request.setAttribute("userList",userList);
//            request.setAttribute("divisionList",divisionList);
//            request.setAttribute("educationDegreeList",educationDegreeList);
//            request.setAttribute("positionList",positionList);
//            try {
//                request.getRequestDispatcher("employee/createEmployee.html").forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        private void displayEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            List<Employee> employeeList=employeeBO.findAllEmployee();
//            String action=request.getParameter("action");
//            request.setAttribute("action","employee");
//            request.setAttribute("employeeList",employeeList);
//            request.getRequestDispatcher("display.html").forward(request,response);
//        }
}
