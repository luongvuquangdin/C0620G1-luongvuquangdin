package bo.boemployee;


import dao.daoemployee.DivisionDAO;
import dao.daoemployee.DivisionDAOImpl;
import dao.daoemployee.EducationDegreeDAO;
import dao.daoemployee.EducationDegreeDAOOImpl;
import model.modelemployee.EducationDegree;

import java.util.List;

public class EducationDegreeBOImpl implements EducationDegreeBO {
    EducationDegreeDAO educationDegreeDAO=new EducationDegreeDAOOImpl();
    @Override
    public List<EducationDegree> findAllEducationDegree() {
        return educationDegreeDAO.findAllEducationDegree();
    }
}
