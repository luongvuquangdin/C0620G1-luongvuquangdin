package bo.employee_bo;


import dao.employee_dao.EducationDegreeDAO;
import dao.employee_dao.EducationDegreeDAOOImpl;
import model.employee.EducationDegree;

import java.util.List;

public class EducationDegreeBOImpl implements EducationDegreeBO {
    EducationDegreeDAO educationDegreeDAO=new EducationDegreeDAOOImpl();
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeDAO.findAllEducationDegree();
    }
}
