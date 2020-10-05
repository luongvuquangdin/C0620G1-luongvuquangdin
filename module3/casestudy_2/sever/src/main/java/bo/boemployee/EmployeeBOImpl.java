package bo.boemployee;

import dao.daoemployee.EmployeeDAO;
import dao.daoemployee.EmployeeDAOImpl;

import model.modelemployee.Employee;

import java.util.List;

public class EmployeeBOImpl implements EmployeeBO {
    private EmployeeDAO employeeDAO=new EmployeeDAOImpl();
    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.findAllEmployee();
    }

    @Override
    public String createEmployee(Employee employee) {
        return employeeDAO.createEmployee(employee);
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
        return employeeDAO.editEmployee(employee);
    }

    @Override
    public List<Employee> findEmployeeByName(String employeeName) {
        return employeeDAO.findEmployeeByName(employeeName);
    }
}
