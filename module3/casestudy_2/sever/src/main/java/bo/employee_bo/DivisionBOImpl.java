package bo.employee_bo;

import dao.employee_dao.DivisionDAO;
import dao.employee_dao.DivisionDAOImpl;
import model.employee.Division;

import java.util.List;

public class DivisionBOImpl implements DivisionBO {
    DivisionDAO divisionDAO=new DivisionDAOImpl();
    @Override
    public List<Division> findAllDivision() {
        return divisionDAO.findAllDivision();
    }
}
