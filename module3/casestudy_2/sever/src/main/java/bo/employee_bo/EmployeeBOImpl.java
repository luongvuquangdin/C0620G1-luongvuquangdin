package bo.employee_bo;

import common.ValidateEmail;
import common.ValidateNumber;
import dao.employee_dao.EmployeeDAO;
import dao.employee_dao.EmployeeDAOImpl;

import model.employee.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    private EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.findAllEmployee();
    }

    @Override
    public String createEmployee(Employee employee) {
        String message=null;
        boolean checkNumberPhone= ValidateNumber.checkPhone(employee.getEmployeePhone());
        boolean checkIdCard=ValidateNumber.checkIdCard(employee.getEmployeeIdCard());
        boolean checkEmail= ValidateEmail.checkEmail(employee.getEmployeeEmail());
        boolean checkSalary= ValidateNumber.checkPositiveNumber(employee.getEmployeeSalary());
        if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX";
        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
        else if (!checkEmail) message="Email format is abc@gmail.com";
        else if (!checkSalary) message="Salary is positive Number";
        else message=employeeDAO.createEmployee(employee);
        return message;
    }

    @Override
    public Employee findEmployeeById(String id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    public String deleteEmployee(String id) {
        return employeeDAO.deleteEmployee(id);
    }

    @Override
    public String editEmployee(Employee employee) {
        String message=null;
        boolean checkNumberPhone= ValidateNumber.checkPhone(employee.getEmployeePhone());
        boolean checkIdCard=ValidateNumber.checkIdCard(employee.getEmployeeIdCard());
        boolean checkEmail= ValidateEmail.checkEmail(employee.getEmployeeEmail());
        if (!checkNumberPhone) message="Phone number format is 090XXXXXXX or 091XXXXXXX or (84)+90XXXXXXX or (84)+91XXXXXXX";
        else if (!checkIdCard) message="Customer id card format is XXXXXXXXX (X is number 0-9)";
        else if (!checkEmail) message="Email format is abc@gmail.com";
        else message=employeeDAO.editEmployee(employee);
        return message;
    }

    @Override
    public List<Employee> findEmployeeByName(String employeeName) {
        return employeeDAO.findEmployeeByName(employeeName);
    }
}
